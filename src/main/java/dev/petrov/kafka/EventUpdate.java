package dev.petrov.kafka;

public class EventUpdate {
    private FieldChange<String> name;
    private FieldChange<Integer> maxPlaces;
    private FieldChange<String> date;
    private FieldChange<Integer> cost;
    private FieldChange<Integer> duration;
    private FieldChange<Long> locationId;

    public EventUpdate(
            FieldChange<String> name,
            FieldChange<Integer> maxPlaces,
            FieldChange<String> date,
            FieldChange<Integer> cost,
            FieldChange<Integer> duration,
            FieldChange<Long> locationId
    ) {
        this.name = name;
        this.maxPlaces = maxPlaces;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.locationId = locationId;
    }

    public void setName(FieldChange<String> name) {
        this.name = name;
    }

    public void setMaxPlaces(FieldChange<Integer> maxPlaces) {
        this.maxPlaces = maxPlaces;
    }

    public void setDate(FieldChange<String> date) {
        this.date = date;
    }

    public void setCost(FieldChange<Integer> cost) {
        this.cost = cost;
    }

    public void setDuration(FieldChange<Integer> duration) {
        this.duration = duration;
    }

    public void setLocationId(FieldChange<Long> locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return " {" +
                "name=" + name +
                ", maxPlaces=" + maxPlaces +
                ", date=" + date +
                ", cost=" + cost +
                ", duration=" + duration +
                ", locationId=" + locationId +
                " }";
    }
}
