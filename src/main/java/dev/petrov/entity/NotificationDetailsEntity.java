package dev.petrov.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_details")
public class NotificationDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "new_name")
    private String newName;
    @Column(name = "new_max_places")
    private String newMaxPlaces;
    @Column(name = "new_date")
    private String newDate;
    @Column(name = "new_cost")
    private String newCost;
    @Column(name = "new_duration")
    private String newDuration;
    @Column(name = "new_location_id")
    private String newLocationId;
    @Column(name = "old_name")
    private String oldName;
    @Column(name = "old_max_places")
    private String oldMaxPlaces;
    @Column(name = "old_date")
    private String oldDate;
    @Column(name = "old_cost")
    private String oldCost;
    @Column(name = "old_duration")
    private String oldDuration;
    @Column(name = "old_location_id")
    private String oldLocationId;

    public NotificationDetailsEntity() {
    }

    public NotificationDetailsEntity(
            String newName,
            String newMaxPlaces,
            String newDate,
            String newCost,
            String newDuration,
            String newLocationId,
            String oldName,
            String oldMaxPlaces,
            String oldDate,
            String oldCost,
            String oldDuration,
            String oldLocationId
    ) {
        this.newName = newName;
        this.newMaxPlaces = newMaxPlaces;
        this.newDate = newDate;
        this.newCost = newCost;
        this.newDuration = newDuration;
        this.newLocationId = newLocationId;
        this.oldName = oldName;
        this.oldMaxPlaces = oldMaxPlaces;
        this.oldDate = oldDate;
        this.oldCost = oldCost;
        this.oldDuration = oldDuration;
        this.oldLocationId = oldLocationId;
    }

    public String getNewName() {
        return newName;
    }

    public String getNewMaxPlaces() {
        return newMaxPlaces;
    }

    public String getNewDate() {
        return newDate;
    }

    public String getNewCost() {
        return newCost;
    }

    public String getNewDuration() {
        return newDuration;
    }

    public String getNewLocationId() {
        return newLocationId;
    }

    public String getOldName() {
        return oldName;
    }

    public String getOldMaxPlaces() {
        return oldMaxPlaces;
    }

    public String getOldDate() {
        return oldDate;
    }

    public String getOldCost() {
        return oldCost;
    }

    public String getOldDuration() {
        return oldDuration;
    }

    public String getOldLocationId() {
        return oldLocationId;
    }


}
