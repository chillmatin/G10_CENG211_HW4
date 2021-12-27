package Managements;


import java.util.Random;

public class RentalCalculator {

    private static double discountRate;
    private static int randInt;

    static double calculatePrice(RentalData<?> rentalData) {
        double daily_price = rentalData.getCarBasePrice() * rentalData.getModelYearRatio();
        calculateDiscountRate(rentalData);

        if (rentalData.getCustomerType().equals("Commercial")) {
            double d = daily_price * rentalData.getRentalTime() * 30 * discountRate;
            return (double) (Math.round(d * 100.0) / 100);
        } else {
            double d = daily_price * rentalData.getRentalTime() * 1 * discountRate;
            return (double) (Math.round(d * 100.0) / 100);
        }


    }

    private static void calculateDiscountRate(RentalData<?> rentalData) {
        if (rentalData.getMembership().equals("Member")) {
            discountRate = 0.9;
        } else if (rentalData.getMembership().equals("S")) {
            discountRate = 0.8;
        } else if (rentalData.getMembership().equals("G")) {
            discountRate = 0.75;
        } else if (rentalData.getMembership().equals("P")) {
            discountRate = 0.7;
        } else {
            discountRate = 1;
        }

    }

    static int getRentalCode() {
        return randInt;
    }

    static int generateRentalCode() {
        Random random = new Random();
        randInt = random.nextInt((9999999) + 1);
        return randInt;
    }

}
