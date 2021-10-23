package factorymethod;

public class VolkswagenCar extends Car {
	@Override
	public String getName() {
		return CarType.Volkswagen.getValue();
	}
}
