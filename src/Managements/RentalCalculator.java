package Managements;


import java.util.ArrayList;
import java.util.Hashtable;


class RentalCalculator {

    private double discountRate = 1;

    private final Hashtable<String, Double> membershipsAndDiscounts = new Hashtable<>();


    public double calculatePrice(RentalData<?> rentalData) {
        double daily_price = rentalData.getCarBasePrice() * rentalData.getModelYearRatio();
        calculateDiscountRate(rentalData);
        if (rentalData.getCustomerType().equals("Commercial")) {
            double d = daily_price * rentalData.getRentalTime() * 30 * discountRate;

            RentalCounter.addTotalCommercialRentals();
            RentalCounter.addTotalCommercialRentalMonth(rentalData.getRentalTime());

            return (double) (Math.round(d * 1000.0)/100);
        }

        else {

            double d = daily_price * rentalData.getRentalTime() * 1 * discountRate;

            RentalCounter.addTotalIndividualRentals();
            RentalCounter.addTotalIndividualRentalDay(rentalData.getRentalTime());

            return (double) (Math.round(d * 1000.00)/100);
        }

    }

    private void calculateDiscountRate(RentalData<?> rentalData) {
        RentalCounter.addTotalCarRented();

        if (membershipsAndDiscounts.containsKey(rentalData.getMembership())) {
            discountRate = membershipsAndDiscounts.get(rentalData.getMembership());
            RentalCounter.addTotalMemberRentals(rentalData.getMembership());

        } else {//not membership
            RentalCounter.addTotalNonMemberIndividualRentals();
            discountRate = 1;
        }

    }

    public void updateMembershipTypes(ArrayList<String> memberships, ArrayList<Double> discounts) {
        for (int i = 0; i < memberships.size(); i++) {
            membershipsAndDiscounts.put(memberships.get(i), discounts.get(i));
        }
    }
}
