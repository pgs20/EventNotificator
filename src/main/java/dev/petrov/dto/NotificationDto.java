package dev.petrov.dto;

public record NotificationDto(
        Long idNotification,
        Integer idEvent,
        String fieldsChangeEvent
){
}
