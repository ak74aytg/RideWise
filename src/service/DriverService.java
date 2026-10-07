package service;

import exception.NoDriverAvailableException;
import helper.Utils;
import model.Driver;
import model.Location;
import model.VEHICLE_TYPE;

import java.util.ArrayList;
import java.util.List;

public class DriverService {
    private static final List<Driver> registeredDrivers = new ArrayList<>();

    public static Driver registerDriver(String name, VEHICLE_TYPE vehicleType) {
        Utils.validateName(name);
        Driver driver = new Driver(name, vehicleType);
        registeredDrivers.add(driver);
        return driver;
    }

    public static Driver getDriverById(Integer id) {
        for (Driver driver : registeredDrivers) {
            if (driver.getId() == id) {
                return driver;
            }
        }
        throw new NoDriverAvailableException();
    }

    public static void updateAvailability(Integer id, boolean available) {
        Driver  driver = getDriverById(id);
        driver.setAvailable(available);
    }

    public static void updateLocation(Integer id, Location location) {
        Driver  driver = getDriverById(id);
        driver.setCurrentLocation(location);
    }

    public static List<Driver> availableDrivers() {
        return registeredDrivers.stream().filter(driver -> Boolean.TRUE.equals(driver.getAvailable())).toList();
    }

}
