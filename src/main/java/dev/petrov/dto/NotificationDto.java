package dev.petrov.dto;

public record NotificationDto(
        Long idNotification,
        Integer idEvent,
        String name,
        String maxPlaces,
        String date,
        String cost,
        String duration,
        String locationId
){
}
