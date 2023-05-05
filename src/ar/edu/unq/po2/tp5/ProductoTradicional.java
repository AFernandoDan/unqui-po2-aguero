package ar.edu.unq.po2.tp5;

public class ProductoTradicional extends Producto {
	
	public ProductoTradicional(String nombre, float precioBase, int stock) {
		super(nombre, precioBase, stock);
	}
	
	public float getPrecio() {
		return getPrecioBase();
	}
}