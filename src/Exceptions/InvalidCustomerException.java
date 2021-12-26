package Exceptions;

public class InvalidCustomerException extends InvalidRentalDataException{
    InvalidCustomerException(){
        super("Customer data is invalid");
    }

    InvalidCustomerException(String message){
        super(message);
    }
}
