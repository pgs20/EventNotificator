package dev.petrov.dto;

public record Notification(
        Long idNotification,
        Integer idEvent,
        String name,
        String maxPlaces,
        String date,
        String cost,
        String duration,
        String locationId){
}
