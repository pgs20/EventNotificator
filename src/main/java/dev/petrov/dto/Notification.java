package dev.petrov.dto;

import dev.petrov.kafka.FieldChange;

public class Notification {
    private Integer idEvent;
    private FieldChange<String> name;
    private FieldChange<String> maxPlaces;
    private FieldChange<String> date;
    private FieldChange<String> cost;
    private FieldChange<String> duration;
    private FieldChange<String> locationId;

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public void setName(FieldChange<String> name) {
        this.name = name;
    }

    public void setMaxPlaces(FieldChange<String> maxPlaces) {
        this.maxPlaces = maxPlaces;
    }

    public void setDate(FieldChange<String> date) {
        this.date = date;
    }

    public void setCost(FieldChange<String> cost) {
        this.cost = cost;
    }

    public void setDuration(FieldChange<String> duration) {
        this.duration = duration;
    }

    public void setLocationId(FieldChange<String> locationId) {
        this.locationId = locationId;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public FieldChange<String> getName() {
        return name;
    }

    public FieldChange<String> getMaxPlaces() {
        return maxPlaces;
    }

    public FieldChange<String> getDate() {
        return date;
    }

    public FieldChange<String> getCost() {
        return cost;
    }

    public FieldChange<String> getDuration() {
        return duration;
    }

    public FieldChange<String> getLocationId() {
        return locationId;
    }
}
