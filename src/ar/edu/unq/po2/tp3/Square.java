package ar.edu.unq.po2.tp3;

public class Square {
	private Rectangle innerRectangle;
	Square(Point vertex, int side) {
		setInnerRectangle(new Rectangle(vertex, side, side));
	}
	
	public Rectangle getInnerRectangle() {
		return innerRectangle;
	}
	
	public void setInnerRectangle(Rectangle innerRectangle) {
		this.innerRectangle = innerRectangle;
	}

	public Integer getArea() {
		return getInnerRectangle().getArea();
	}
	
	public Integer getPerimeter() {
		return getInnerRectangle().getPerimeter();
	}
}
