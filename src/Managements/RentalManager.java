package Managements;

import Actors.Car;
import Actors.Customers.*;
import Exceptions.InvalidCustomerException;
import Interfaces.IRentalChecker;
import Interfaces.IRentalCounter;
import Interfaces.IRentalManager;


import java.util.ArrayList;
import java.util.Collections;


public class RentalManager implements IRentalManager {

    private ArrayList<RentalData<?>> individualRentals = new ArrayList<>();
    private ArrayList<RentalData<?>> commercialRentals = new ArrayList<>();

    private ArrayList<String> membershipTypes = new ArrayList<>();
    private ArrayList<Double> discountRates = new ArrayList<>();



    private IRentalChecker rentalChecker;
    private IRentalCounter rentalCounter;
    private RentalCalculator rentalCalculator;

    public RentalManager(){
        rentalChecker= new RentalChecker();
        rentalCalculator=  new RentalCalculator();
        rentalCounter = new RentalCounter();
        String[] memberships = {"Member","S","G","P"};
        Double[] discounts = {0.9,0.8,0.75,0.7};

        Collections.addAll(discountRates, discounts);
        Collections.addAll(membershipTypes, memberships);


    }

    public void takeStats() {
        FileIO.readFile("HW4_Rentals.csv");
        ArrayList<String> dataArray = FileIO.getDataArray();

        rentalCalculator.updateMembershipTypes(membershipTypes,discountRates);

        for (String element : dataArray) {
            String[] splitElement = element.split(",");

            String customerType = splitElement[0];
            String id = splitElement[1];
            int time = Integer.parseInt(splitElement[2]);

            try {

                Customer<?> customer = setCustomer(id, customerType);
                Car car = new Car(splitElement[3], splitElement[4], splitElement[5]);

                RentalData<?> rentalData = setRentalData(customer, car, time);

                double price= rentalCalculator.calculatePrice(rentalData);
                rentalData.setRentalPrice(price);

                listAssign(rentalData);

            } catch (InvalidCustomerException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void addNewMembershipType(String newMembershipType,Double discountRate) {
        membershipTypes.add(newMembershipType);
        discountRates.add(discountRate);

        rentalCalculator.updateMembershipTypes(membershipTypes,discountRates);
    }

    private void listAssign(RentalData<?> rentalData) {
        if (rentalData.getCustomerType().equals("Individual")) {
            individualRentals.add(rentalData);
        } else {
            commercialRentals.add(rentalData);
        }
    }

    private <T> RentalData<T> setRentalData(Customer<T> customer, Car car, int time) {
        return new RentalData<>(customer, car, time);
    }

    private Customer<?> setCustomer(String id, String customerType) throws InvalidCustomerException {

        if (rentalChecker.checkIdValidity(id)) {
            if (customerType.equals("Individual")) {
                if (rentalChecker.isNumeric(id)) {
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


    void printIndividualTable() {
        System.out.println("Individual Rentals:");
        int i = 0;
        for (RentalData<?> element : individualRentals) {
            i++;
            System.out.println(i + ", " + element.getRentalCode() + ", " + element.getId() + "," +
                    " " + element.getMembership() + ", " + element.getRentalTime() + " days," +
                    " " + element.getCarModel() + ", " + element.getModelYear() + ", " + element.getRentalPrice()+"$");

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

    public void printStats() {
        System.out.println("Welcome..");
        rentalCounter.printCounters();
        printIndividualTable();
        printCommercialTable();
    }




}

