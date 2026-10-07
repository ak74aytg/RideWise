package exception;

public class NoDriverAvailableException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "No driver exist with this id";
    }
}
