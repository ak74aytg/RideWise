package observer;

import model.STATUS_TYPE;

public class SecurityObserver implements Observer{
    @Override
    public void onStatusUpdate(STATUS_TYPE status) {
        System.out.println("[Security] : Ride status has been changed to " + status);
    }
}
