package model;

import java.time.LocalDateTime;

public class Driver extends User{
    private Location currentLocation;
    private Boolean available;
    private VEHICLE_TYPE vehicle;
    private LocalDateTime lastRide;

    public Driver(String name, VEHICLE_TYPE vehicle) {
        this.vehicle = vehicle;
        this.available = false;
        super(name);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getName() {
        return super.getName();
    }

    public LocalDateTime getLastRide() {
        return lastRide;
    }

    public void setLastRide(LocalDateTime lastRide) {
        this.lastRide = lastRide;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name=" + super.getName() + "\n" +
                "currentLocation=" + currentLocation +
                ", vehicle=" + vehicle +
                "}\n";
    }
}
