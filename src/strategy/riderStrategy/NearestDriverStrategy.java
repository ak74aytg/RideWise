package strategy.riderStrategy;

import helper.Utils;
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
            double distance = Utils.getDistance(driverLoc, rider.getLocation());
            if (nearestDistance > distance) {
                nearestDriver = driver;
                nearestDistance = distance;
            }
        }
        return nearestDriver;
    }
}
