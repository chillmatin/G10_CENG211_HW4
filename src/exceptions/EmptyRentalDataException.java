package exceptions;

public class EmptyRentalDataException extends InvalidRentalDataException {
    public EmptyRentalDataException() {
        super("Rental Data is Empty.");
    }

    public EmptyRentalDataException(String message) {
        super(message);
    }

}
