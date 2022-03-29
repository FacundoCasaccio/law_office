package exceptions;

public class InvalidServiceException extends Exception {
    public InvalidServiceException(String message) {
        super(message);
    }
}
