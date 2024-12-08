package dev.petrov.converter;

import dev.petrov.dto.Notification;
import dev.petrov.dto.NotificationDto;
import dev.petrov.entity.NotificationDetailsEntity;
import dev.petrov.entity.NotificationEntity;
import dev.petrov.kafka.FieldChange;
import org.springframework.stereotype.Component;

@Component
public class ConverterNotification {

    public Notification toDomain(NotificationEntity entity) {
        NotificationDetailsEntity details = entity.getDetails();
        return new Notification(
                entity.getEventId(),
                new FieldChange<>(details.getNewName(), details.getOldName()),
                new FieldChange<>(details.getNewMaxPlaces(), details.getOldMaxPlaces()),
                new FieldChange<>(details.getNewDate(), details.getOldDate()),
                new FieldChange<>(details.getNewCost(), details.getOldCost()),
                new FieldChange<>(details.getNewDuration(), details.getOldDuration()),
                new FieldChange<>(details.getNewLocationId(), details.getOldLocationId())
        );
    }

    public NotificationDto toDto(Notification domain) {
        return new NotificationDto(
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
