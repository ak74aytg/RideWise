package strategy.fareStrategy;

import model.Ride;

public class FairFactory {
    public static FareStrategy getFairFactor(String strategy) {
        return switch (strategy) {
            case "default" -> new DefaultFareStrategy();
            case "peak" -> new PeakHourFareStrategy();
            default -> throw new IllegalArgumentException("No fair strategy exist with this name");
        };
    }
}
