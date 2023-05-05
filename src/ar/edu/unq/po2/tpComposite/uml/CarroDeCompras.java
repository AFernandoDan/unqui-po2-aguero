package ar.edu.unq.po2.tpComposite.uml;

import java.util.List;

public class CarroDeCompras {

	private List<Product> elements;
	
	public CarroDeCompras(List<Product> elements) {
		setElements(elements);
	}
	
	private void setElements(List<Product> elements) {
		this.elements = elements;
	}
	
	public List<Product> getElements() {
		return elements;
	}
	
	public int totalRounded() {
		return (int) Math.floor(total());
	}
	
	public float total() {
		return (float) getElements().stream().mapToDouble(p -> (double) p.getPrice()).sum();
	}
}
