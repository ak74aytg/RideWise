package model;

import helper.IdGenerator;
import observer.Observer;
import strategy.riderStrategy.NearestDriverStrategy;
import strategy.riderStrategy.RideMatchingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ride {
    private Integer id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private STATUS_TYPE status;
    private RideMatchingStrategy rideStrategy = new NearestDriverStrategy();
    private List<Observer> observers = new ArrayList<>();

    public Ride(Rider rider, STATUS_TYPE status) {
        this.rider = rider;
        this.status = status;
        this.id = IdGenerator.getRandomId();
    }

    public Integer getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public STATUS_TYPE getStatus() {
        return status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setStatus(STATUS_TYPE status) {
        if (this.status == status) return;

        this.status = status;
        for (Observer observer : observers) {
            observer.onStatusUpdate(status);
        }
    }

    public void setRideStrategy(RideMatchingStrategy rideStrategy) {
        this.rideStrategy = rideStrategy;
    }

    public RideMatchingStrategy getRideStrategy() {
        return rideStrategy;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", rider=" + rider +
                ", driver=" + driver +
                ", distance=" + distance +
                ", status=" + status +
                '}';
    }
}
