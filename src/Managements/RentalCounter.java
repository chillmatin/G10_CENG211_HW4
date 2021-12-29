package Managements;

import Interfaces.IRentalCounter;

class RentalCounter implements IRentalCounter {

    private int totalCarRented = 0;
    private int totalCommercialRentals = 0;
    private int totalCommercialRentalMonth = 0;
    private int totalIndividualRentals = 0;
    private int totalIndividualRentalDay = 0;
    private int totalNonMemberIndividualRentals = 0;
    private int totalMemberIndividualRentals = 0;
    private int totalSilverMemberCommercialRentals = 0;
    private int totalGoldMemberCommercialRentals = 0;
    private int totalPlatinumMemberCommercialRentals = 0;

    public void addTotalCarRented() {
        totalCarRented++;
    }

    public void addTotalCommercialRentals() {
        totalCommercialRentals++;
    }

    public void addTotalCommercialRentalMonth(int time) {
        totalCommercialRentalMonth += time;
    }

    public void addTotalIndividualRentals() {
        totalIndividualRentals++;
    }

    public void addTotalIndividualRentalDay(int time) {
        totalIndividualRentalDay += time;
    }

    public void addTotalNonMemberIndividualRentals() {
        totalNonMemberIndividualRentals++;
    }

    public void addTotalMemberIndividualRentals() {
        totalMemberIndividualRentals++;
    }

    public void addTotalSilverMemberCommercialRentals() {
        totalSilverMemberCommercialRentals++;
    }

    public void addTotalGoldMemberCommercialRentals() {
        totalGoldMemberCommercialRentals++;
    }

    public void addTotalPlatinumMemberCommercialRentals() {
        totalPlatinumMemberCommercialRentals++;
    }


    private int getTotalCarRented() {
        return totalCarRented;
    }

    private int getTotalCommercialRentals() {
        return totalCommercialRentals;
    }

    private int getTotalCommercialRentalMonth() {
        return totalCommercialRentalMonth;
    }

    private int getTotalIndividualRentals() {
        return totalIndividualRentals;
    }

    private int getTotalIndividualRentalDay() {
        return totalIndividualRentalDay;
    }

    private int getTotalNonMemberIndividualRentals() {
        return totalNonMemberIndividualRentals;
    }

    private int getTotalMemberIndividualRentals() {
        return totalMemberIndividualRentals;
    }

    private int getTotalSilverMemberCommercialRentals() {
        return totalSilverMemberCommercialRentals;
    }

    private int getTotalGoldMemberCommercialRentals() {
        return totalGoldMemberCommercialRentals;
    }

    private  int getTotalPlatinumMemberCommercialRentals() {
        return totalPlatinumMemberCommercialRentals;
    }

     public void printCounters() {
        System.out.println("Total number of cars rented:" + getTotalCarRented());
        System.out.println("Total number of commercial rentals:" + getTotalCommercialRentals());
        System.out.println("Total number of commercial rental-month:" + getTotalCommercialRentalMonth());
        System.out.println("Total number of individual rentals:" + getTotalIndividualRentals());
        System.out.println("Total number of individual rentals-day:" + getTotalIndividualRentalDay());
        System.out.println("Total number of rentals of individual non-member customers:" + getTotalNonMemberIndividualRentals());
        System.out.println("Total number of rentals of individual member customers:" + getTotalMemberIndividualRentals());
        System.out.println("Total number of rentals of silver commercial customers:" + getTotalSilverMemberCommercialRentals());
        System.out.println("Total number of rentals of gold commercial customers:" + getTotalGoldMemberCommercialRentals());
        System.out.println("Total number of rentals of platinum commercial customers:" + getTotalPlatinumMemberCommercialRentals());
    }

}
