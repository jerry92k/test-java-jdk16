package apitest;

public class Car {
    private int price;
    private String carName;

    public Car(int price, String carName) {
        this.price = price;
        this.carName = carName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void changeCarName(String newName){
        carName="new_"+newName;
    }

    @Override
    public String toString() {
        return "oldtest.Car{" +
                "price=" + price +
                ", carName='" + carName + '\'' +
                '}';
    }

}
