import interfaces.IRentalManager;
import managements.RentalManager;


/**
 * visit github repository: https://github.com/chillmetin/G10_CENG211_HW4
 */
public class RentACarApp {
    public static void main(String[] args) {
        IRentalManager manager = new RentalManager();


        manager.addNewMembershipType("B",0.35);     // adding new commercial membership type
                                                                               // demonstration
        manager.takeStats("HW4_Rentals.csv");
        manager.printStats();

    }
}