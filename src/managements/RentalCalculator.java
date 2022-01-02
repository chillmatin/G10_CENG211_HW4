package managements;

import java.util.ArrayList;
import java.util.LinkedHashMap;


class RentalCalculator {

    private double discountRate = 1;

    private  LinkedHashMap<String, Double> membershipsAndDiscounts = new LinkedHashMap<>();


    public double calculatePrice(RentalData<?> rentalData) {
        double daily_price = rentalData.getCarBasePrice() * rentalData.getModelYearRatio();

        calculateDiscountRate(rentalData);

        if (rentalData.getCustomerType().equals("Commercial")) {
            double d = daily_price * rentalData.getRentalTime() * 30 * discountRate;

            RentalCounter.addTotalCommercialRentals();
            RentalCounter.addTotalCommercialRentalMonth(rentalData.getRentalTime());

            return  d;
        } else {

            double d = daily_price * rentalData.getRentalTime() * 1 * discountRate;

            RentalCounter.addTotalIndividualRentals();
            RentalCounter.addTotalIndividualRentalDay(rentalData.getRentalTime());

            return (double) (Math.round(d * 100.00) / 100);
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

    void updateMembershipTypes(ArrayList<String> memberships, ArrayList<Double> discounts) {

        for (int i = 0; i < memberships.size(); i++) {
            membershipsAndDiscounts.put(memberships.get(i), discounts.get(i));
        }
    }
}