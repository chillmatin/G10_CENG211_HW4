import Customers.Customer;

import java.util.ArrayList;

public class RentalManager{


    public void manageIt(){
        FileIO.readFile("HW4_Rentals.csv");
        ArrayList<String> rentalDataArray = FileIO.getDataArray();

        for(String element:rentalDataArray){
           String[] splitElement = element.split(",");

        }
    }
}
