package Managements;

class RentalCounter {

    static int totalCarRented = 0;
    static int totalCommercialRentals = 0;
    static int totalCommercialRentalMonth = 0;
    static int totalIndividualRentals = 0;
    static int totalIndividualRentalDay = 0;
    static int totalNonMemberIndividualRentals = 0;
    static int totalMemberIndividualRentals = 0;
    static int totalSilverMemberCommercialRentals = 0;
    static int totalGoldMemberCommercialRentals = 0;
    static int totalPlatinumMemberCommercialRentals = 0;


     static int getTotalCarRented() {
        return totalCarRented;
    }

    static int getTotalCommercialRentals() {
        return totalCommercialRentals;
    }

     static int getTotalCommercialRentalMonth() {
        return totalCommercialRentalMonth;
    }

     static int getTotalIndividualRentals() {
        return totalIndividualRentals;
    }

     static int getTotalIndividualRentalDay() {
        return totalIndividualRentalDay;
    }

     static int getTotalNonMemberIndividualRentals() {
        return totalNonMemberIndividualRentals;
    }

     static int getTotalMemberIndividualRentals() {
        return totalMemberIndividualRentals;
    }

     static int getTotalSilverMemberCommercialRentals() {
        return totalSilverMemberCommercialRentals;
    }

     static int getTotalGoldMemberCommercialRentals() {
        return totalGoldMemberCommercialRentals;
    }

    public static int getTotalPlatinumMemberCommercialRentals() {
        return totalPlatinumMemberCommercialRentals;
    }

    static void printCounters() {
        System.out.println("Total number of cars rented:" + RentalCounter.getTotalCarRented());
        System.out.println("Total number of commercial rentals:" + RentalCounter.getTotalCommercialRentals());
        System.out.println("Total number of commercial rental-month:" + RentalCounter.getTotalCommercialRentalMonth());
        System.out.println("Total number of individual rentals:" + RentalCounter.getTotalIndividualRentals());
        System.out.println("Total number of individual rentals-day:" + RentalCounter.getTotalIndividualRentalDay());
        System.out.println("Total number of rentals of individual non-member customers:" + RentalCounter.getTotalNonMemberIndividualRentals());
        System.out.println("Total number of rentals of individual member customers:" + RentalCounter.getTotalMemberIndividualRentals());
        System.out.println("Total number of rentals of silver commercial customers:" + RentalCounter.getTotalSilverMemberCommercialRentals());
        System.out.println("Total number of rentals of gold commercial customers:" + RentalCounter.getTotalGoldMemberCommercialRentals());
        System.out.println("Total number of rentals of platinum commercial customers:" + RentalCounter.getTotalPlatinumMemberCommercialRentals());
    }

}
