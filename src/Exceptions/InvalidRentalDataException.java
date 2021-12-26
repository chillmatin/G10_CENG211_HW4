package Exceptions;

public class InvalidRentalDataException extends Exception {
    public InvalidRentalDataException() {
        super("Rental Data is Invalid");
    }

    public InvalidRentalDataException(String message) {
        super(message);
    }
}
