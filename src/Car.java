public class Car {

    String carModel;
    int modelYear;
    double basePrice;

    Car(String carModel_,String modelYear_,String basePrice_){
        setCarModel(carModel_);
        setModelYear(modelYear_);
        setBasePrice(basePrice_);
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
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", modelYear=" + modelYear +
                ", basePrice=" + basePrice +
                '}';
    }


}
