package dev.petrov.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_id", nullable = false)
    private Integer eventId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "is_read", nullable = false)
    private boolean isRead;
    @Column(name = "status_event")
    private String status;
    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationDetailsEntity> details;

    public NotificationEntity() {
    }

    public NotificationEntity(Integer eventId, List<NotificationDetailsEntity> details, String status) {
        this.eventId = eventId;
        this.details = details;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.isRead = false;
    }

    public List<NotificationDetailsEntity> getDetails() {
        return details;
    }

    public Integer getEventId() {
        return eventId;
    }
    public void setRead(boolean read) {
        isRead = read;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDetails(List<NotificationDetailsEntity> details) {
        this.details = details;
    }
}
