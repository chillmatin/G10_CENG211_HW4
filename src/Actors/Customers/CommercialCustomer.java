package Actors.Customers;

public class CommercialCustomer extends Customer<String> {


    public CommercialCustomer(String id) {
        super(id, "Commercial");
    }

    @Override
    public String toString() {
        return "CommercialCustomer{}";
    }
}
