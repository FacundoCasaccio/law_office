package exceptions;

public class NoLawyerAvailableException extends RuntimeException{
    public NoLawyerAvailableException(String message) {
        super(message);
    }
}
