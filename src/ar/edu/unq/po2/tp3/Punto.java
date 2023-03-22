package ar.edu.unq.po2.tp3;

public class Punto {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	
	public void setXY(int x, int y) {
		this.setX(x);
		this.setX(y);
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

	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
