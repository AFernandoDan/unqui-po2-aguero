package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto {
	
	public ProductoCooperativa(String nombre, float precioBase, int stock) {
		super(nombre, precioBase, stock);
	}
	
	public float getPrecio() {
		return getPrecioBase() * getFactorPorDescuentoIva();
	}

	private float getFactorPorDescuentoIva() {
		return 0.9f;
	}

}