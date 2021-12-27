package Actors.Customers;

public  class Customer<T> {
    private T id;
    private final String customerType;

    public Customer(T id, String customerType) {
        setId(id);
        this.customerType = customerType;
    }

    public T getId() {
        return id;
    }

    private void setId(T id){
        this.id=id;
    }

    public String getCustomerType() {
        return customerType;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
