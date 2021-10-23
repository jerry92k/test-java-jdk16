package factorymethod;

public class GermanyCarFactory implements CarFactory {

	@Override
	public Car createCar(CarType carType) {
		return switch (carType){
			case Benz -> new BenzCar();
			case Volkswagen -> new VolkswagenCar();
			default -> null;
		};
	}
}
