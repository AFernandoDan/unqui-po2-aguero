package ar.edu.unq.po2.tp3;

public class Rectangle extends Point {
	private Point lowerLeftVertex;
	private int height;
	private int width;
	
	/** 
	 * /
	 * @param vertex is the lower left vertex of the rectangle.
	 * @param height is >= 0.
	 * @param width	is >= 0.
	 */
	
	Rectangle(Point vertex, int height, int width) {
		setVertexHeightWidth(vertex, height, width);
	}
	
	private void setVertexHeightWidth(Point vertex, int height, int width) {
		setLowerLeftVertex(vertex);
		setHeight(height);
		setWidth(width);
	}
	
	public Point getLowerLeftVertex() {
		return lowerLeftVertex;
	}

	public void setLowerLeftVertex(Point lowerLeftVertex) {
		this.lowerLeftVertex = lowerLeftVertex;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getArea() {
		return getHeight() * getWidth();
	}

	private int getHeight() {
		return height;
	}

	private int getWidth() {
		return width;
	}

	public Integer getPerimeter() {
		return 2 * (getHeight() + getWidth());
	}

	public boolean isHorizontal() {
		return getWidth() > getHeight();
	}

	public boolean isVertical() {
		return getHeight() > getWidth();
	}
}
