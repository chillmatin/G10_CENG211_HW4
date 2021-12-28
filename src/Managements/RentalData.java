package Managements;

import Actors.*;
import Actors.Customers.*;
import Exceptions.InvalidCustomerException;


import java.util.Objects;

class RentalData<T> {

    private final int rentalTime;
    private double modelYearRatio;
    private final int rentalCode;
    private int rentalPrice;

    private final Customer<T> customer;
    private final Car car;


    RentalData(Customer<T> customer, Car car, int time) {
        this.customer = customer;
        this.car = car;
        this.rentalTime = time;
        RentalCalculator.generateRentalCode();
        this.rentalCode =RentalCalculator.getRentalCode();
        this.rentalPrice = (int) RentalCalculator.calculatePrice(this);
        modelYearRatio = 0; //by default.

    }

    int getRentalTime() {
        return rentalTime;
    }

    //---

    Customer<T> getCustomer() {
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
                throw new InvalidCustomerException("Membership is invalid");
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

    int getRentalCode() {
        return rentalCode;
    }

    int getRentalPrice() {
        return rentalPrice;
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
