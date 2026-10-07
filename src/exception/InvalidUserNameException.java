package exception;

public class InvalidUserNameException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "Name cannot be empty or null.";
    }
}
