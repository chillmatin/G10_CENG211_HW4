package Exceptions;

public class InvalidRentalDataException extends Exception{
    InvalidRentalDataException(){
        super("Rental Data is Invalid");
    }
    InvalidRentalDataException(String message){
        super(message);
    }

}
