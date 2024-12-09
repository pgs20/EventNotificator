package dev.petrov.controller;

import dev.petrov.converter.ConverterNotification;
import dev.petrov.dto.NotificationDto;
import dev.petrov.dto.ReadNotification;
import dev.petrov.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Void> readNotifications(@RequestBody ReadNotification readNotification) {
        notificationService.readNotifications(readNotification.notificationIds());

        return ResponseEntity.ok().build();
    }
}
