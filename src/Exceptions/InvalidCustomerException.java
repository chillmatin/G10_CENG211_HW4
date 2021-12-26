package Exceptions;

public class InvalidCustomerException extends InvalidRentalDataException {
    public InvalidCustomerException() {
        super("Customer data is invalid");
    }

    public InvalidCustomerException(String message) {
        super(message);
    }
}
