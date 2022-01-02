package interfaces;

public interface IRentalManager {
    void takeStats(String file); // Takes the rental data information stats from the FileIO and process it.
    void printStats();
    void addNewMembershipType(String newMembershipType,Double discountRate);

}