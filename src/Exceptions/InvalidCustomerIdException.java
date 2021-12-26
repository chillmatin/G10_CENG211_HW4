package Exceptions;

public class InvalidCustomerIdException extends InvalidCustomerException {
    public InvalidCustomerIdException() {
        super("Customer's Id is invalid.");
    }

    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
