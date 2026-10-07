package helper;

import exception.InvalidLocationException;
import exception.InvalidUserNameException;
import model.Location;

public class Utils {
    public static double getDistance(Location location1, Location location2) {
        double xCoordinate = location2.getLatitude() - location1.getLatitude();
        double yCoordinate = location2.getLongitude() - location1.getLongitude();

        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
    }

    public static void validateName(String name) {
        System.out.println("am i here");
        if (null == name || name.trim().isEmpty()) {
            throw new InvalidUserNameException();
        }
    }

    public static void validateLocation(Location location) {
        if (location.getLongitude() <= 0 || location.getLatitude() <= 0) {
            throw new InvalidLocationException();
        }
    }
}
