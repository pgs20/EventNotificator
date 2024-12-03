package dev.petrov.dto;

public record Notification(
        Long idNotification,
        Integer idEvent,
        String fieldsChangeEvent
){
}
