package dev.petrov.dto;

import dev.petrov.kafka.FieldChange;

public record Notification(
        Integer idEvent,
        FieldChange<String> name,
        FieldChange<String> maxPlaces,
        FieldChange<String> date,
        FieldChange<String> cost,
        FieldChange<String> duration,
        FieldChange<String> locationId)
{
}
