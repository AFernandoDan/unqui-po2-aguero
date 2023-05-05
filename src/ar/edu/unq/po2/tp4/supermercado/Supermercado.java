package ar.edu.unq.po2.tp4.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	
	private String nombre;
	private String direccion;
	private List<ProductoGenerico> productos = new ArrayList<ProductoGenerico>();

	public Supermercado(String nombre, String direccion) {
		super();
	}

	public Integer getCantidadDeProductos() {
		return productos.size();
	}

	public void agregarProducto(ProductoGenerico producto) {
		productos.add(producto);
	}

	public Double getPrecioTotal() {
		return productos.stream()
	    .mapToDouble(producto -> producto.getPrecio())
	    .reduce(0, (a, b) -> a + b);
	}
}
