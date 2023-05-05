package ar.edu.unq.po2.tp4.supermercado;

public class Producto extends ProductoGenerico{

	public Producto(String nombre, Double precioBase, Boolean esPecioCuidado) {
		super(nombre, precioBase, esPecioCuidado);
	}

	public Producto(String nombre, double precioBase) {
		super(nombre, precioBase);
	}

	@Override
	public Double getPrecio() {
		return getPrecioBase();
	}
	
}
