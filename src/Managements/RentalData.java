package Managements;

import Actors.*;
import Actors.Customers.*;

import java.io.Serializable;
import java.util.Objects;

public class RentalData<T> {

    private int rentalTime;
    private Customer<? extends Serializable> customer;
    private Car car;


    RentalData(Customer<? extends Serializable> customer, Car car, int time){
        this.customer=customer;
        this.car=car;
        this.rentalTime=time;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public Customer<? extends Serializable> getCustomer() {
        return new Customer<>(customer.getId(),customer.getCustomerType());
    }


    public Car getCar() {
        return new Car(car.getCarModel(),car.getModelYear(),car.getBasePrice());
    }


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
