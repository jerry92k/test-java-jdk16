package apitest;

public class Calculator {

	public static int sum(int numberX, int numberY) {
		return numberX + numberY;
	}

	public static double sum(double numberX, double numberY) {
		return numberX + numberY;
	}

	public static double sum(String numberX, String numberY) {
		try {
			return Double.parseDouble(numberX) + Double.parseDouble(numberY);
		} catch (NumberFormatException ex) {
			System.out.println(ex);
			return 0.0;
		}
	}

	public static void main(String[] args) {
		System.out.println(Calculator.sum(1,2));
		System.out.println(Calculator.sum(3.7,5.3));
		System.out.println(Calculator.sum("2.42","5"));
		System.out.println(Calculator.sum("일","십"));
	}
}
