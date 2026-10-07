package strategy;

import model.Ride;

public class DefaultFareStrategy implements FareStrategy{
    private static Integer DEFAULT_PRICE_PER_UNIT_DISTANCE = 10;
    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance() * DEFAULT_PRICE_PER_UNIT_DISTANCE;
    }
}
