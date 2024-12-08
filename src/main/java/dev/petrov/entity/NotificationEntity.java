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
    private LocalDateTime createdAt;
    @Column(name = "is_read", nullable = false)
    private boolean isRead;
    @Column(name = "status_event")
    private String status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private NotificationDetailsEntity details;

    public NotificationEntity() {
    }

    public NotificationEntity(Integer eventId, NotificationDetailsEntity details, String status) {
        this.eventId = eventId;
        this.details = details;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.isRead = false;
    }

    public NotificationDetailsEntity getDetails() {
        return details;
    }
    public Integer getEventId() {
        return eventId;
    }
    public void setRead(boolean read) {
        isRead = read;
    }
}
