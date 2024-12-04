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
                entity.getName(),
                entity.getMaxPlaces(),
                entity.getDate(),
                entity.getCost(),
                entity.getDuration(),
                entity.getLocationId()
        );
    }

    public NotificationDto toDto(Notification domain) {
        return new NotificationDto(
                domain.idNotification(),
                domain.idEvent(),
                domain.name(),
                domain.maxPlaces(),
                domain.date(),
                domain.cost(),
                domain.duration(),
                domain.locationId()
        );
    }
}
