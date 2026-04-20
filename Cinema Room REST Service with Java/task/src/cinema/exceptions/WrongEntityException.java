package cinema.exceptions;

public class WrongEntityException extends RuntimeException {
    public WrongEntityException(String message) {
        super(message);
    }
}
