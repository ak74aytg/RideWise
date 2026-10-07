package strategy.fareStrategy;

import model.Ride;

public class PeakHourFareStrategy implements FareStrategy{
    private static Integer PEAK_HOUR_PRICE_PER_UNIT_DISTANCE = 30;

    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance() * PEAK_HOUR_PRICE_PER_UNIT_DISTANCE;
    }
}
