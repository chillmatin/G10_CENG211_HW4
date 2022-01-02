package actors;

import java.util.Objects;

public class Car {

    private String carModel;
    private int modelYear;
    private double basePrice;

    public Car(String carModel, String modelYear, String basePrice) {
        setCarModel(carModel);
        setModelYear(modelYear);
        setBasePrice(basePrice);
    }

    public Car(String carModel, int modelYear, double basePrice) {
        setCarModel(carModel);
        this.modelYear = modelYear;
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getCarModel() {
        return carModel;
    }

    private void setBasePrice(String basePrice) {
        this.basePrice = Double.parseDouble(basePrice);
    }

    private void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    private void setModelYear(String modelYear) {
        this.modelYear = Integer.parseInt(modelYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return modelYear == car.modelYear && Double.compare(car.basePrice, basePrice) == 0 && Objects.equals(carModel, car.carModel);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", modelYear=" + modelYear +
                ", basePrice=" + basePrice +
                '}';
    }
}