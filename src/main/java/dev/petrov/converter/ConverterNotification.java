package dev.petrov.converter;

import dev.petrov.dto.Notification;
import dev.petrov.dto.NotificationDto;
import dev.petrov.entity.NotificationEntity;
import org.springframework.stereotype.Component;

@Component
public class ConverterNotification {

    public Notification toDomain(NotificationEntity entity) {
        return new Notification(
                entity.getId(),
                entity.getEventId(),
                entity.getFieldChange()
        );
    }

    public NotificationDto toDto(Notification domain) {
        return new NotificationDto(
                domain.idNotification(),
                domain.idEvent(),
                domain.fieldsChangeEvent()
        );
    }
}
