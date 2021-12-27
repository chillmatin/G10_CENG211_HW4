package Managements;

import Actors.Car;
import Actors.Customers.*;



import java.util.ArrayList;

public class RentalManager {


    public void manageRentalData() {
        FileIO.readFile("HW4_Rentals.csv");
        ArrayList<String> rentalDataArray = FileIO.getDataArray();

        for (String element : rentalDataArray) {
            String[] splitElement = element.split(",");

            Car car = new Car(splitElement[3], splitElement[4], splitElement[5]);

            String id = splitElement[1];
            String customerType = splitElement[0];


            if(customerType.equals("Individual")){
                if(isNumeric(id)){
                    IndividualCustomer<Integer> customer = new IndividualCustomer<>(Integer.parseInt(id),false);
                }
                else{
                    IndividualCustomer<String> customer = new IndividualCustomer<>(id,true);
                }
            }
            else{ // Commercial
                CommercialCustomer customer = new CommercialCustomer(id);
            }


        }

    }


    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
