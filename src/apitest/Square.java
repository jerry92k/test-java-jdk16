package apitest;

public class Square extends Rectangle{

	// public oldtest.Square(int width, int height) {
	// 	super(width, height);
	// }

	public Square(int side) {
		super(side,side);
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}

	public static void main(String[] args){
		int width=5;
		int height=3;
		Rectangle rectangle = new Rectangle(width,height);
		Rectangle square = new Square(width);
	}
}
