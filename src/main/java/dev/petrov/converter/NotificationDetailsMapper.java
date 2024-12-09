package dev.petrov.converter;

import dev.petrov.entity.NotificationDetailsEntity;
import dev.petrov.entity.NotificationEntity;
import dev.petrov.kafka.EventKafkaNotification;
import dev.petrov.kafka.FieldChange;

import java.util.ArrayList;
import java.util.List;

public class NotificationDetailsMapper {

    public static NotificationEntity mapEventToNotificationDetails(
            EventKafkaNotification eventNotification,
            NotificationEntity notification) {

        List<NotificationDetailsEntity> detailsList = new ArrayList<>();

        addFieldChangeToDetails(detailsList, notification, "name", eventNotification.name());
        addFieldChangeToDetails(detailsList, notification, "maxPlaces", eventNotification.maxPlaces());
        addFieldChangeToDetails(detailsList, notification, "date", eventNotification.date());
        addFieldChangeToDetails(detailsList, notification, "cost", eventNotification.cost());
        addFieldChangeToDetails(detailsList, notification, "duration", eventNotification.duration());
        addFieldChangeToDetails(detailsList, notification, "locationId", eventNotification.locationId());

        notification.setDetails(detailsList);
        notification.setEventId(eventNotification.eventId());
        notification.setStatus(eventNotification.status());

        return notification;
    }

    private static <T> void addFieldChangeToDetails(
            List<NotificationDetailsEntity> detailsList,
            NotificationEntity notification,
            String fieldName,
            FieldChange<T> fieldChange) {

        if (fieldChange.getNewField() != null || fieldChange.getNewField() != fieldChange.getOldField()) {
            NotificationDetailsEntity detail = new NotificationDetailsEntity();
            detail.setNotification(notification);
            detail.setFieldName(fieldName);
            detail.setOldValue(fieldChange.getOldField().toString());
            detail.setNewValue(fieldChange.getNewField().toString());
            detailsList.add(detail);
        }
    }
}
