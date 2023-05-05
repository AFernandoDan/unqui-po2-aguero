package ar.edu.unq.po2.tp3;

public class Point {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	
	public void setXY(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y) {
		super();
		setXY(x,y);
	}
	
	public Point() {
		super();
		setXY(0,0);
	}

	public void moveTo(int newX, int newY) {
		setXY(newX, newY);
	}

	public void addWith(Point otherPoint) {
		moveTo(
				getX() + otherPoint.getX(),
				getY() + otherPoint.getY());
	}
	
}
