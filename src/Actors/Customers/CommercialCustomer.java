package Actors.Customers;

public class CommercialCustomer extends Customer<String> {

    String membershipType;

    public CommercialCustomer(String id) {
        super(id, "Commercial");
        membershipType = id.split("")[0];
    }

    public String getMembershipType() {
        return membershipType;
    }

}
