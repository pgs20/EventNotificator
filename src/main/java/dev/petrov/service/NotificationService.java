package dev.petrov.service;

import dev.petrov.converter.ConverterNotification;
import dev.petrov.dto.Notification;
import dev.petrov.entity.NotificationEntity;
import dev.petrov.kafka.EventKafkaNotification;
import dev.petrov.repository.NotificationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final ConverterNotification converterNotification;

    public NotificationService(NotificationRepository notificationRepository, ConverterNotification converterNotification) {
        this.notificationRepository = notificationRepository;
        this.converterNotification = converterNotification;
    }

    public List<Notification> getAllNotification() {
        return notificationRepository.findByIsReadFalse()
                .filter(eventEntities -> !eventEntities.isEmpty())
                .map(eventEntities -> eventEntities.stream()
                        .map(converterNotification::toDomain)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new EntityNotFoundException("Непрочитанных нотификаций нет"));
    }

    public void saveEntity(EventKafkaNotification event) {
        NotificationEntity entity = new NotificationEntity(
                event.eventId(),
                event.name().toString(),
                event.maxPlaces().toString(),
                event.date().toString(),
                event.cost().toString(),
                event.duration().toString(),
                event.locationId().toString()
        );

        notificationRepository.save(entity);
    }

    public void readNotifications(List<Long> notificationIds) {
        for (Long id : notificationIds) {
            notificationRepository.findById(id).ifPresent(notification -> {
                notification.setRead(true);
                notificationRepository.save(notification);
            });
        }
    }

    @Scheduled(fixedRate = 60000) // Запуск каждую минуту для теста
    private void deleteOldNotifications() {
        LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1); // Для теста взял 1 минуту
        List<NotificationEntity> oldNotifications = notificationRepository.findByCreatedAtBefore(oneMinuteAgo);
        notificationRepository.deleteAll(oldNotifications);
    }
}
