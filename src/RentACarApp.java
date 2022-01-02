import Interfaces.IRentalManager;
import Managements.RentalManager;


public class RentACarApp {
    public static void main(String[] args) {
        IRentalManager manager = new RentalManager();



        manager.takeStats();
        manager.addNewMembershipType("B",0.5);
        manager.printStats();

        //TODO: Please note that the company may add new commercial customer types in the future (Hint:Interfaces). Bunu gözardı etmişim bunu
        // yapmak gerek.

        //TODO : INTERFACE VE UMLLER!


    }
}
