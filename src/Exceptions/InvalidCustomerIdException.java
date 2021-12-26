package Exceptions;

public class InvalidCustomerIdException extends InvalidCustomerException {
    InvalidCustomerIdException() {
        super("Customer's Id is invalid.");
    }

    InvalidCustomerIdException(String message) {
        super(message);
    }
}
