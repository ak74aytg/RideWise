package strategy.riderStrategy;

import model.Driver;
import model.Rider;

import java.time.LocalDateTime;
import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {
        Driver leastActiveDriver = null;
        LocalDateTime lastRide = null;
        for (Driver driver : drivers) {
            if (lastRide == null) {
                lastRide = driver.getLastRide();
                leastActiveDriver = driver;
                continue;
            }
            if (lastRide.isAfter(driver.getLastRide())) {
                lastRide = driver.getLastRide();
                leastActiveDriver = driver;
            }
        }
        return leastActiveDriver;
    }
}
