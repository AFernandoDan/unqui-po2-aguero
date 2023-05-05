package ar.edu.unq.po2.tpComposite.uml;

public class Product {

	private float price;
	private String name;
	
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
