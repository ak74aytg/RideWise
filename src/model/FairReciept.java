package model;

import java.time.LocalDateTime;

public class FairReciept {
    private Integer rideId;
    private double amount;
    private LocalDateTime generatedAt;

    public FairReciept(LocalDateTime generatedAt, double amount, Integer rideId) {
        this.generatedAt = generatedAt;
        this.amount = amount;
        this.rideId = rideId;
    }

    @Override
    public String toString() {
        return "FairReciept{" +
                "rideId=" + rideId +
                ", amount=" + amount +
                ", generatedAt=" + generatedAt +
                '}';
    }
}
