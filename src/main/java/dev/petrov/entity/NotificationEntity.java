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
    @Column(name = "is_read", nullable = false)
    private boolean isRead;
    @Column(name = "field_update_name")
    private String name;
    @Column(name = "field_update_max_places")
    private String maxPlaces;
    @Column(name = "field_update_date")
    private String date;
    @Column(name = "field_update_cost")
    private String cost;
    @Column(name = "field_update_duration")
    private String duration;
    @Column(name = "field_update_location_id")
    private String locationId;


    public NotificationEntity() {
    }

    public NotificationEntity(Integer eventId, String name, String maxPlaces, String date, String cost, String duration, String locationId) {
        this.eventId = eventId;
        this.name = name;
        this.maxPlaces = maxPlaces;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.locationId = locationId;
        this.createdAt = LocalDateTime.now().toString();
        this.isRead = false;
    }

    public Long getId() {
        return id;
    }
    public Integer getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getMaxPlaces() {
        return maxPlaces;
    }

    public String getDate() {
        return date;
    }

    public String getCost() {
        return cost;
    }

    public String getDuration() {
        return duration;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
