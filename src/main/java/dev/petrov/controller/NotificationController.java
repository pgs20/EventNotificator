package dev.petrov.controller;

import dev.petrov.converter.ConverterNotification;
import dev.petrov.dto.NotificationDto;
import dev.petrov.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final ConverterNotification converterNotification;

    public NotificationController(NotificationService notificationService, ConverterNotification converterNotification) {
        this.notificationService = notificationService;
        this.converterNotification = converterNotification;
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAllNotification() {
        return ResponseEntity.ok()
                .body(
                        notificationService.getAllNotification()
                                .stream()
                                .map(converterNotification::toDto)
                                .collect(Collectors.toList())
                );
    }
}
