package Customers;

public class IndividualCustomer<T> extends Customer<T>{

    IndividualCustomer(T id,boolean isMember) {
        super(id, "Individual");
    }

}
