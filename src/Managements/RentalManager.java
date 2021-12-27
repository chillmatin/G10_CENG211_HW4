package Managements;

import Actors.Car;
import Actors.Customers.*;
import Exceptions.InvalidCustomerException;


import java.util.ArrayList;


public class RentalManager {
    ArrayList<String> rentalDataArray;

    ArrayList<RentalData<?>> individualRentals = new ArrayList<>();
    ArrayList<RentalData<?>> commercialRentals = new ArrayList<>();



    public void processRentals() {
        FileIO.readFile("HW4_Rentals.csv");
        rentalDataArray = FileIO.getDataArray();

        for (String element : rentalDataArray) {
            String[] splitElement = element.split(",");
            String customerType = splitElement[0];
            String id = splitElement[1];
            int time = Integer.parseInt(splitElement[2]);

            try {
                Customer<?> customer = setCustomer(id, customerType);
                Car car = new Car(splitElement[3], splitElement[4], splitElement[5]);

                RentalData<?> rentalData = engraveRentalData(customer, car, time);

                if (rentalData.getCustomerType().equals("Individual")) {
                    individualRentals.add(rentalData);
                    RentalCounter.totalIndividualRentals++;
                } else {
                    commercialRentals.add(rentalData);
                    RentalCounter.totalCommercialRentals++;
                }

                RentalCounter.totalCarRented++;

            } catch (InvalidCustomerException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private <T> RentalData<T> engraveRentalData(Customer<T> customer, Car car, int time) {
        return new RentalData<>(customer, car, time);
    }


    private Customer<?> setCustomer(String id, String customerType) throws InvalidCustomerException {
        if (RentalChecker.checkIdValidity(id)) {
            if (customerType.equals("Individual")) {
                if (RentalChecker.isNumeric(id)) {
                    RentalCounter.totalMemberIndividualRentals++;
                    return new IndividualCustomer<>(Long.parseLong(id), false);

                } else {
                    RentalCounter.totalNonMemberIndividualRentals++;
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

    void printCounters(){
        System.out.println("Total number of cars rented:"+RentalCounter.getTotalCarRented());
        System.out.println("Total number of commercial rentals:"+RentalCounter.getTotalCommercialRentals());
        System.out.println("Total number of commercial rental-month:"+RentalCounter.getTotalCommercialRentalMonth());
        System.out.println("Total number of individual rentals:"+RentalCounter.getTotalIndividualRentals());
        System.out.println("Total number of individual rentals-day:"+RentalCounter.getTotalIndividualRentalDay());
        System.out.println("Total number of rentals of individual non-member customers:"+RentalCounter.getTotalNonMemberIndividualRentals());
        System.out.println("Total number of rentals of individual member customers:"+RentalCounter.getTotalMemberIndividualRentals());
        System.out.println("Total number of rentals of silver commercial customers:"+RentalCounter.getTotalSilverMemberCommercialRentals());
        System.out.println("Total number of rentals of gold commercial customers:"+RentalCounter.getTotalGoldMemberCommercialRentals());
        System.out.println("Total number of rentals of platinum commercial customers:"+RentalCounter.getTotalPlatinumMemberCommercialRentals());
    }

    void printIndividualTable() {
        System.out.println("Individual Rentals:");

        int i = 0;
        for (RentalData<?> element : individualRentals) {
            i++;
            System.out.println(i + ", " + element.getRentalCode() + ", " + element.getId() + "," +
                    " " + element.getMembership() + ", " + element.getRentalTime() + " days," +
                    " " + element.getCarModel() + ", " + element.getModelYear() + ", " + element.getRentalPrice());

        }
    }

    void printCommercialTable() {
        System.out.println("Commercial Rentals:");

        int i = 0;

        for (RentalData<?> element : commercialRentals) {
            i++;
            System.out.println(i + ", " + element.getRentalCode() + ", " + element.getId() + "," +
                    " " + element.getMembership() + ", " + element.getRentalTime() + " months," +
                    " " + element.getCarModel() + ", " + element.getModelYear() + ", " + element.getRentalPrice());

        }
    }

    public void printStatistics(){
        System.out.println("Welcome");
        printCounters();
        printIndividualTable();
        printCommercialTable();
    }


}

