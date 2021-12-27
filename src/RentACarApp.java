import Managements.RentalManager;

public class RentACarApp {
    public static void main(String[] args)  {
        RentalManager manager = new RentalManager();
        manager.processRentals();
        manager.printIndividualTable();
        manager.printCommercialTable();

    }
}
