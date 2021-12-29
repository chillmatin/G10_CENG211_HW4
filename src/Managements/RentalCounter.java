package Managements;

import Interfaces.IRentalCounter;

class RentalCounter implements IRentalCounter {

    private static int totalCarRented = 0;
    private static int totalCommercialRentals = 0;
    private static int totalCommercialRentalMonth = 0;
    private static int totalIndividualRentals = 0;
    private static int totalIndividualRentalDay = 0;
    private static int totalNonMemberIndividualRentals = 0;
    private static int totalMemberIndividualRentals = 0;
    private static int totalSilverMemberCommercialRentals = 0;
    private static int totalGoldMemberCommercialRentals = 0;
    private static int totalPlatinumMemberCommercialRentals = 0;

    public static void addTotalCarRented() {
        totalCarRented++;
    }

    public static void addTotalCommercialRentals() {
        totalCommercialRentals++;
    }

    public static void addTotalCommercialRentalMonth(int time) {
        totalCommercialRentalMonth += time;
    }

    public static void addTotalIndividualRentals() {
        totalIndividualRentals++;
    }

    public static void addTotalIndividualRentalDay(int time) {
        totalIndividualRentalDay += time;
    }

    public static void addTotalNonMemberIndividualRentals() {
        totalNonMemberIndividualRentals++;
    }

    public static void addTotalMemberIndividualRentals() {
        totalMemberIndividualRentals++;
    }

    public static void addTotalSilverMemberCommercialRentals() {
        totalSilverMemberCommercialRentals++;
    }

    public static void addTotalGoldMemberCommercialRentals() {
        totalGoldMemberCommercialRentals++;
    }

    public static void addTotalPlatinumMemberCommercialRentals() {
        totalPlatinumMemberCommercialRentals++;
    }


    public void printCounters() {
        System.out.println("Total number of cars rented:" + totalCarRented);
        System.out.println("Total number of commercial rentals:" + totalCommercialRentals);
        System.out.println("Total number of commercial rental-month:" + totalCommercialRentalMonth );
        System.out.println("Total number of individual rentals:" + totalIndividualRentals);
        System.out.println("Total number of individual rentals-day:" + totalIndividualRentalDay);
        System.out.println("Total number of rentals of individual non-member customers:" + totalNonMemberIndividualRentals);
        System.out.println("Total number of rentals of individual member customers:" + totalMemberIndividualRentals);
        System.out.println("Total number of rentals of silver commercial customers:" + totalSilverMemberCommercialRentals);
        System.out.println("Total number of rentals of gold commercial customers:" + totalGoldMemberCommercialRentals);
        System.out.println("Total number of rentals of platinum commercial customers:" + totalPlatinumMemberCommercialRentals);
    }

}
