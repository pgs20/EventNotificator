package dev.petrov.converter;

import dev.petrov.dto.Notification;
import dev.petrov.dto.NotificationDto;
import dev.petrov.entity.NotificationDetailsEntity;
import dev.petrov.entity.NotificationEntity;
import dev.petrov.kafka.FieldChange;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConverterNotification {

    public Notification toDomain(NotificationEntity entity) {
        List<NotificationDetailsEntity> details = entity.getDetails();

        Map<String, FieldChange<String>> fieldChanges = new HashMap<>();

        for (NotificationDetailsEntity detail : details) {
            String fieldName = detail.getFieldName();
            FieldChange<String> fieldChange = new FieldChange<>(detail.getOldValue(), detail.getNewValue());
            fieldChanges.put(fieldName, fieldChange);
        }

        Notification notification = new Notification();
        notification.setIdEvent(entity.getEventId());

        if (fieldChanges.containsKey("name")) {
            notification.setName(fieldChanges.get("name"));
        }
        if (fieldChanges.containsKey("maxPlaces")) {
            notification.setMaxPlaces(fieldChanges.get("maxPlaces"));
        }
        if (fieldChanges.containsKey("date")) {
            notification.setDate(fieldChanges.get("date"));
        }
        if (fieldChanges.containsKey("cost")) {
            notification.setCost(fieldChanges.get("cost"));
        }
        if (fieldChanges.containsKey("duration")) {
            notification.setDuration(fieldChanges.get("duration"));
        }
        if (fieldChanges.containsKey("locationId")) {
            notification.setLocationId(fieldChanges.get("locationId"));
        }

        return notification;
    }

    public NotificationDto toDto(Notification domain) {
        return new NotificationDto(
                domain.getIdEvent(),
                domain.getName(),
                domain.getMaxPlaces(),
                domain.getDate(),
                domain.getCost(),
                domain.getDuration(),
                domain.getLocationId()
        );
    }
}
