package observer;

import model.STATUS_TYPE;

public class AdminObserver implements Observer{
    @Override
    public void onStatusUpdate(STATUS_TYPE status) {
        System.out.println("[Admin] : Ride status has been changed to " + status);
    }
}
