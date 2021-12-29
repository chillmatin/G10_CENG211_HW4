package Managements;


import java.util.Random;

class RentalCalculator {


    private static double discountRate;
    private static int randInt;
    private RentalCounter rentalCounter;

    RentalCalculator(){
        rentalCounter = new RentalCounter();
    }

    double calculatePrice(RentalData<?> rentalData) {
        double daily_price = rentalData.getCarBasePrice() * rentalData.getModelYearRatio();
        calculateDiscountRate(rentalData);

        if (rentalData.getCustomerType().equals("Commercial")) {
            double d = daily_price * rentalData.getRentalTime() * 30 * discountRate;

            rentalCounter.addTotalCommercialRentals();
            rentalCounter.addTotalCommercialRentalMonth(rentalData.getRentalTime());

            return (double) (Math.round(d * 100.0) / 100);
        } else {

            double d = daily_price * rentalData.getRentalTime() * 1 * discountRate;

            rentalCounter.addTotalIndividualRentals();
            rentalCounter.addTotalIndividualRentalDay(rentalData.getRentalTime());

            return (double) (Math.round(d * 100.0) / 100);
        }


    }

    private void calculateDiscountRate(RentalData<?> rentalData) {
        rentalCounter.addTotalCarRented();
        if (rentalData.getMembership().equals("Member")) {
            rentalCounter.addTotalMemberIndividualRentals();
            discountRate = 0.9;
        } else if (rentalData.getMembership().equals("S")) {
            rentalCounter.addTotalSilverMemberCommercialRentals();
            discountRate = 0.8;
        } else if (rentalData.getMembership().equals("G")) {
            rentalCounter.addTotalGoldMemberCommercialRentals();
            discountRate = 0.75;
        } else if (rentalData.getMembership().equals("P")) {
            rentalCounter.addTotalPlatinumMemberCommercialRentals();
            discountRate = 0.7;
        } else {
            rentalCounter.addTotalNonMemberIndividualRentals();
            discountRate = 1;
        }

    }

    static int getRentalCode() {
        return randInt;
    }

    static void generateRentalCode() {
        Random random = new Random();

        randInt = random.nextInt(1000000, 9999999);
    }

}
