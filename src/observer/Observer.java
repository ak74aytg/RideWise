package observer;

import model.STATUS_TYPE;

public interface Observer {
    public void onStatusUpdate(STATUS_TYPE status);
}
