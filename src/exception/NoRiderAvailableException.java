package exception;

public class NoRiderAvailableException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "No rider exist with this id";
    }
}
