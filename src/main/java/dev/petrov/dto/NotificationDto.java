package dev.petrov.dto;

import dev.petrov.kafka.FieldChange;

public record NotificationDto(
        Integer idEvent,
        FieldChange<String> name,
        FieldChange<String> maxPlaces,
        FieldChange<String> date,
        FieldChange<String> cost,
        FieldChange<String> duration,
        FieldChange<String> locationId
){
}
