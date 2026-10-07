package service;

import helper.Utils;
import model.*;
import observer.AdminObserver;
import observer.SecurityObserver;
import strategy.fareStrategy.FairFactory;
import strategy.riderStrategy.RideMatchingStrategy;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class RideService {

    private static Ride assignDriver(Ride ride, List<Driver> drivers) {
        Driver driver = ride.getRideStrategy().findDriver(ride.getRider(), drivers);
        ride.setDriver(driver);
        ride.setDistance(
                Utils.getDistance(
                        ride.getRider().getLocation(), driver.getCurrentLocation()
                )
        );
        ride.setStatus(STATUS_TYPE.ACCEPTED);
        return ride;
    }


    public static Ride requestRide(Rider rider, RideMatchingStrategy rideMatchingStrategy) {
        Ride ride = new Ride(rider, STATUS_TYPE.CREATED);
        System.out.println("================= A Ride has been request =================");
        System.out.println();
        if (null != rideMatchingStrategy) {
            ride.setRideStrategy(rideMatchingStrategy);
        }
        ride.addObserver(new AdminObserver());
        ride.addObserver(new SecurityObserver());
        assignDriver(ride, DriverService.availableDrivers());
        return ride;
    }

    private static FairReciept getFairPrice(Ride ride) {
        LocalTime now = LocalTime.now();
        LocalTime sixPM = LocalTime.of(18, 0);
        double rideFair = 0.0;

        if (now.isBefore(sixPM)) {
            rideFair = FairFactory.getFairFactor("default").calculateFare(ride);
        } else {
            rideFair = FairFactory.getFairFactor("peak").calculateFare(ride);
        }

        return new FairReciept(LocalDateTime.now(), rideFair, ride.getId());
    }

    public static void cancelRide(Ride ride) {
        ride.setStatus(STATUS_TYPE.CANCELED);
    }

    public static void completeRide(Ride ride) {
        FairReciept reciept = getFairPrice(ride);
        ride.setStatus(STATUS_TYPE.COMPLETED);
        System.out.println(reciept);
    }
}
