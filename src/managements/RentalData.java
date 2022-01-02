package managements;

import actors.*;
import actors.customers.*;
import exceptions.InvalidCustomerException;


import java.util.Objects;
import java.util.Random;

public class RentalData<T> {

    private int rentalTime;
    private double modelYearRatio;
    private int rentalCode;
    private double rentalPrice;

    private final Customer<T> customer;
    private final Car car;


    RentalData(Customer<T> customer, Car car, int time) {

        this.customer = customer;
        this.car = car;
        this.rentalTime = time;
        generateRentalCode();

        modelYearRatio = 0; //by default.

    }

    int getRentalTime() {
        return rentalTime;
    }


    private Customer<T> getCustomer() {
        return new Customer<>(customer.getId(), customer.getCustomerType());
    }


    private Car getCar() {
        return new Car(car.getCarModel(), car.getModelYear(), car.getBasePrice());
    }

    double getModelYearRatio() {

        if (car.getModelYear() == 2022) {
            modelYearRatio = 1;
        } else if (car.getModelYear() == 2020 || car.getModelYear() == 2021) {
            modelYearRatio = 0.95;
        } else {
            modelYearRatio = 0.90;
        }
        return modelYearRatio;
    }

    double getCarBasePrice() {
        return car.getBasePrice();
    }

    String getCarModel() {
        return car.getCarModel();
    }

    String getMembership() {
        try {
            if (getCustomerType().equals("Individual")) {
                if (((IndividualCustomer<?>) customer).isMember()) {
                    return "Member";
                } else {
                    return "Not Member";
                }
            } else if (getCustomerType().equals("Commercial")) {
                return ((CommercialCustomer) customer).getMembershipType();
            } else {
                throw new InvalidCustomerException("Membership is not valid");
            }

        } catch (InvalidCustomerException e) {
            System.out.println(e.getMessage());
        }
        return "Not Member";
    }

    int getModelYear() {
        return getCar().getModelYear();
    }

    String getCustomerType() {
        return getCustomer().getCustomerType();
    }

    T getId() {
        return getCustomer().getId();
    }

    private void generateRentalCode() {
        Random random = new Random();
        rentalCode = random.nextInt(1000000, 9999999);
    }


    int getRentalCode() {
        return rentalCode;
    }

    double getRentalPrice() {
        return rentalPrice;
    }

    void setRentalPrice(double rentalPrice_) { //package access to rental manager set the rental's price.
        this.rentalPrice = rentalPrice_;
    }


    //---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalData<?> that = (RentalData<?>) o;
        return rentalTime == that.rentalTime && Objects.equals(customer, that.customer) && Objects.equals(car, that.car);
    }

    @Override
    public String toString() {
        return "RentalData{" +
                "rentalTime=" + rentalTime +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}