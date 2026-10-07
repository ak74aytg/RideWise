package service;

import exception.NoRiderAvailableException;
import helper.Utils;
import model.Location;
import model.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderService {
    private static final List<Rider> registeredRiders = new ArrayList<>();

    public static Rider registerRider(String name, Location location) {
        Utils.validateName(name);
        Utils.validateLocation(location);
        Rider rider = new Rider(name, location);
        registeredRiders.add(rider);
        return rider;
    }

    public static Rider getRiderById(Integer id) {
        for (Rider rider : registeredRiders) {
            if (rider.getId() == id) {
                return rider;
            }
        }
        throw new NoRiderAvailableException();
    }
}
