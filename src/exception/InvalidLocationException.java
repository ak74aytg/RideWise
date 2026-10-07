package exception;

public class InvalidLocationException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "Location cannot have negative/zero latitude or longitude";
    }
}
