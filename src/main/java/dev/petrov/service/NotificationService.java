package dev.petrov.service;

import dev.petrov.converter.ConverterNotification;
import dev.petrov.dto.Notification;
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
}
