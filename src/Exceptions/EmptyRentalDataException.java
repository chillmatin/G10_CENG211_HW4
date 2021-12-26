package Exceptions;

public class EmptyRentalDataException extends InvalidRentalDataException {
    EmptyRentalDataException() {
        super("Rental Data is Empty.");
    }

    EmptyRentalDataException(String message) {
        super(message);
    }
}
