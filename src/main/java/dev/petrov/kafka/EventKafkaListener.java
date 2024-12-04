package dev.petrov.kafka;

import dev.petrov.service.NotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventKafkaListener {

    private final Logger log = LoggerFactory.getLogger(EventKafkaListener.class);
    private final NotificationService notificationService;

    public EventKafkaListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "event-topic", containerFactory = "containerFactory")
    public void listenEvents(
            ConsumerRecord<Integer, EventKafkaNotification> record
    ) {
        log.info("get event: {}", record.value());
        notificationService.saveEntity(record.value());
    }
}
