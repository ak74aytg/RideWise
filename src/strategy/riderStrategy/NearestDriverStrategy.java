package strategy;

import model.Driver;
import model.Location;
import model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        Driver nearestDriver = null;
        double nearestDistance = Integer.MAX_VALUE;
        for (Driver driver : drivers) {
            Location driverLoc = driver.getCurrentLocation();
            double distance = getDistance(driverLoc, rider.getLocation());
            if (nearestDistance > distance) {
                nearestDriver = driver;
                nearestDistance = distance;
            }
        }
        return nearestDriver;
    }

    private double getDistance(Location location1, Location location2) {
        double xCoordinate = location2.getLatitude() - location1.getLatitude();
        double yCoordinate = location2.getLongitude() - location1.getLongitude();

        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
    }
}
