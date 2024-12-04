package dev.petrov.dto;

import java.util.List;

public record ReadNotification(
        List<Long> notificationIds
) {
}
