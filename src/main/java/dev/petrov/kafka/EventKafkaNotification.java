package dev.petrov.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record EventKafkaNotification(
        Integer eventId,
        Integer userIdChangesEvent,
        String ownerId,
        List<Integer> subscribersEvent,
        FieldChange<String> name,
        FieldChange<Integer> maxPlaces,
        FieldChange<String> date,
        FieldChange<Integer> cost,
        FieldChange<Integer> duration,
        FieldChange<Long> locationId,
        String status
) {
}
