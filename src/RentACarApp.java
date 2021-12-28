import Managements.RentalManager;

public class RentACarApp {
    public static void main(String[] args) {
        RentalManager manager = new RentalManager();
        manager.processRentals();
        manager.printStatistics();

        //TODO: Please note that the company may add new commercial customer types in the future (Hint:Interfaces). Bunu gözardı etmişim bunu
        // yapmak gerek.

        //TODO : INTERFACE VE UMLLER!


    }
}
