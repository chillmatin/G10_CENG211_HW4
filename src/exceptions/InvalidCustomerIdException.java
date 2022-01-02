package exceptions;

public class InvalidCustomerIdException extends InvalidCustomerException {
    public InvalidCustomerIdException() {
        super("Customer's id is invalid.");
    }

    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
