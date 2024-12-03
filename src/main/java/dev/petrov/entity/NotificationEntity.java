package dev.petrov.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_id", nullable = false)
    private Integer eventId;
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "field_change_event")
    private String fieldChange;
    @Column(name = "is_read", nullable = false)
    private boolean isRead;

    public NotificationEntity() {
    }

    public NotificationEntity(Integer eventId, String fieldChange) {
        this.eventId = eventId;
        this.fieldChange = fieldChange;
        this.createdAt = LocalDateTime.now().toString();
        this.isRead = false;
    }

    public Long getId() {
        return id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getFieldChange() {
        return fieldChange;
    }
}
