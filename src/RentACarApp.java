import interfaces.IRentalManager;
import managements.RentalManager;


public class RentACarApp {
    public static void main(String[] args) {
        IRentalManager manager = new RentalManager();


        manager.addNewMembershipType("B",0.35);
        manager.takeStats("HW4_Rentals.csv");
        manager.printStats();

    }
}