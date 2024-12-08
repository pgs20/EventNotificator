package dev.petrov.service;

import dev.petrov.entity.NotificationEntity;
import dev.petrov.repository.NotificationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeleteOldNotificationService {

    private NotificationRepository notificationRepository;

    public DeleteOldNotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Scheduled(fixedRate = 60000) // Запуск каждую минуту для теста
    private void deleteOldNotifications() {
        LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1); // Для теста взял 1 минуту
        notificationRepository.deleteAll(notificationRepository.findByCreatedAtBefore(oneMinuteAgo));
    }
}
