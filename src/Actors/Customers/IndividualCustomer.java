package Actors.Customers;

public class IndividualCustomer<T> extends Customer<T>{

    public IndividualCustomer(T id, boolean isMember) {
        super(id, "Individual");
    }


}
