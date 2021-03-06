package jigsaw.car.notexported;

public class PrivateCar {
    private int price;
    private String carName;

    public PrivateCar(int price, String carName) {
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
        return "Car{" +
                "price=" + price +
                ", carName='" + carName + '\'' +
                '}';
    }
}
