package actors.customers;

public class CommercialCustomer extends Customer<String> {

    private String membershipType;

    public CommercialCustomer(String id) {
        super(id, "Commercial");
        membershipType = id.split("")[0];
    }

    public String getMembershipType() {
        return membershipType;
    }

}
