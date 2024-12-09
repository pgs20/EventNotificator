package dev.petrov.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_details")
public class NotificationDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "notification_id", nullable = false)
    private NotificationEntity notification;
    @Column(name = "field_name", nullable = false)
    private String fieldName;
    @Column(name = "old_value")
    private String oldValue;
    @Column(name = "new_value")
    private String newValue;

    public NotificationDetailsEntity() {
    }

    public NotificationDetailsEntity(String fieldName, String oldValue, String newValue) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNotification(NotificationEntity notification) {
        this.notification = notification;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
