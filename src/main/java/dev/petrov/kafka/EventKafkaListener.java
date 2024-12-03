package dev.petrov.kafka;

import dev.petrov.entity.NotificationEntity;
import dev.petrov.repository.NotificationRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventKafkaListener {

    private final Logger log = LoggerFactory.getLogger(EventKafkaListener.class);
    private final NotificationRepository notificationRepository;

    public EventKafkaListener(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @KafkaListener(topics = "event-topic", containerFactory = "containerFactory")
    public void listenEvents(
            ConsumerRecord<Integer, EventKafkaNotification> record
    ) {
        log.info("get event: {}", record.value());
        notificationRepository.save(
                new NotificationEntity(
                        record.value().eventId(),
                        record.value().event().toString()
        ));
    }
}
