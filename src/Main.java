import model.*;
import service.DriverService;
import service.RideService;
import service.RiderService;
import strategy.riderStrategy.NearestDriverStrategy;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rider rider1 = RiderService
                .registerRider("akshay", new Location(101.2, 121.32));

        Driver driver1 = DriverService.registerDriver("Raju", VEHICLE_TYPE.BIKE);
        Driver driver2 = DriverService.registerDriver("Ramu", VEHICLE_TYPE.CAR);
        Driver driver3 = DriverService.registerDriver("Rajesh", VEHICLE_TYPE.BIKE);
        Driver driver4 = DriverService.registerDriver("Kamal", VEHICLE_TYPE.BIKE);
        Driver driver5 = DriverService.registerDriver("Abdul", VEHICLE_TYPE.BIKE);

        // Update drivers location
        DriverService.updateLocation(driver1.getId(), new Location(102.2, 122.2));
        DriverService.updateLocation(driver2.getId(), new Location(202.2, 122.2));
        DriverService.updateLocation(driver3.getId(), new Location(103.2, 222.2));
        DriverService.updateLocation(driver4.getId(), new Location(402.2, 322.2));
        DriverService.updateLocation(driver5.getId(), new Location(39.2, 12.2));

        // Update drivers' availibility
        DriverService.updateAvailability(driver1.getId(), true);
        DriverService.updateAvailability(driver2.getId(), true);
        DriverService.updateAvailability(driver5.getId(), true);

        System.out.println("=============== Available Drivers ==============");
        List<Driver> availableDrivers = DriverService.availableDrivers();
        System.out.println(availableDrivers);

        // Request Ride
        Ride ride = RideService.requestRide(rider1, new NearestDriverStrategy());
        System.out.println(ride);
        RideService.completeRide(ride);
    }
}