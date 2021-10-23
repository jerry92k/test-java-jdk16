package factorymethod;

public enum CarType {

	Benz("benz"),
	Volkswagen("volkswagen");

	private String value;

	CarType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

