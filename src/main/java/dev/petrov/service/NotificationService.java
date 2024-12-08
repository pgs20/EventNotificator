package dev.petrov.service;

import dev.petrov.converter.ConverterNotification;
import dev.petrov.dto.Notification;
import dev.petrov.entity.NotificationDetailsEntity;
import dev.petrov.entity.NotificationEntity;
import dev.petrov.kafka.EventKafkaNotification;
import dev.petrov.repository.NotificationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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
        NotificationDetailsEntity details = new NotificationDetailsEntity(
                event.name().getNewField(),
                event.maxPlaces().getNewField().toString(),
                event.date().getNewField(),
                event.cost().getNewField().toString(),
                event.duration().getNewField().toString(),
                event.locationId().getNewField().toString(),
                event.name().getOldField(),
                event.maxPlaces().getOldField().toString(),
                event.date().getOldField(),
                event.cost().getOldField().toString(),
                event.duration().getOldField().toString(),
                event.locationId().getOldField().toString()
        );

        NotificationEntity entity = new NotificationEntity(
                event.eventId(),
                details,
                event.status()
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
}
