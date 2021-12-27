package Actors.Customers;
//TODO: Think better about customer classes and methods.
public class Customer<T> {
    private T id;
    private String customerType;

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
