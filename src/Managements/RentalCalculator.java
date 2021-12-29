package Managements;


import java.util.Random;

class RentalCalculator {

    private static double discountRate;
    private static int randInt;



    double calculatePrice(RentalData<?> rentalData) {
        double daily_price = rentalData.getCarBasePrice() * rentalData.getModelYearRatio();
        calculateDiscountRate(rentalData);

        if (rentalData.getCustomerType().equals("Commercial")) {
            double d = daily_price * rentalData.getRentalTime() * 30 * discountRate;

            RentalCounter.addTotalCommercialRentals();
            RentalCounter.addTotalCommercialRentalMonth(rentalData.getRentalTime());

            return (double) (Math.round(d * 100.0) / 100);
        } else {

            double d = daily_price * rentalData.getRentalTime() * 1 * discountRate;

            RentalCounter.addTotalIndividualRentals();
            RentalCounter.addTotalIndividualRentalDay(rentalData.getRentalTime());

            return (double) (Math.round(d * 100.0) / 100);
        }


    }

    private void calculateDiscountRate(RentalData<?> rentalData) {
        RentalCounter.addTotalCarRented();
        if (rentalData.getMembership().equals("Member")) {
            RentalCounter.addTotalMemberIndividualRentals();
            discountRate = 0.9;
        } else if (rentalData.getMembership().equals("S")) {
            RentalCounter.addTotalSilverMemberCommercialRentals();
            discountRate = 0.8;
        } else if (rentalData.getMembership().equals("G")) {
            RentalCounter.addTotalGoldMemberCommercialRentals();
            discountRate = 0.75;
        } else if (rentalData.getMembership().equals("P")) {
            RentalCounter.addTotalPlatinumMemberCommercialRentals();
            discountRate = 0.7;
        } else {
            RentalCounter.addTotalNonMemberIndividualRentals();
            discountRate = 1;
        }

    }

     int getRentalCode() {
        return randInt;
    }

     void generateRentalCode() {
        Random random = new Random();
        randInt = random.nextInt(1000000, 9999999);
    }

}
