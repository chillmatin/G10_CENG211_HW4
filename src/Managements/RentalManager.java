package Managements;

import Actors.Car;
import Actors.Customers.*;
import Exceptions.InvalidCustomerException;

import java.io.Serializable;
import java.util.ArrayList;



public class RentalManager {

    ArrayList<String> rentalDataArray;

    public void processRentals() {
        FileIO.readFile("HW4_Rentals.csv");
        rentalDataArray = FileIO.getDataArray();

        for (String element : rentalDataArray) {
            String[] splitElement = element.split(",");

            String customerType = splitElement[0];
            String id = splitElement[1];

            try {
                Customer<? extends Serializable> customer = setCustomer(id, customerType);
                Car car = new Car(splitElement[3], splitElement[4], splitElement[5]);

                // TODO: FIX RentalData rentalData = new RentalData(customer, car, Integer.parseInt(splitElement[2]));

                System.out.println();
            } catch (InvalidCustomerException e) {
                System.out.println(e.getMessage());
            }


        }

    }

    private Customer<? extends Serializable> setCustomer(String id, String customerType) throws InvalidCustomerException {
        if (RentalController.checkIdValidity(id)) {
            if (customerType.equals("Individual")) {
                if (RentalController.isNumeric(id)) {
                    return new IndividualCustomer<>(Long.parseLong(id), false);
                } else {
                    return new IndividualCustomer<>(id, true);
                }
            } else if (customerType.equals("Commercial")) { // Commercial
                return new CommercialCustomer(id);
            } else {
                throw new InvalidCustomerException("Invalid Customer Type!");
            }
        } else {
            throw new InvalidCustomerException("The System couldn't set the customer.");
        }
    }


}

