package factorymethod;

public class BenzCar extends Car {

	@Override
	public String getName() {
		return CarType.Benz.getValue();
	}
}
