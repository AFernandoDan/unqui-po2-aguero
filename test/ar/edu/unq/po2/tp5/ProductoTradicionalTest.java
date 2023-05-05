package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTradicionalTest {
	
	private Producto unProducto;
	
	@BeforeEach
	public void setUp() {
		unProducto = new ProductoTradicional("CocaCola", 10f, 5);
	}

	@Test
	public void elPrecioDeUnProductoEsSuPrecioBase() {
		float precioEsperado = 10f;
		assertEquals(precioEsperado, unProducto.getPrecio());
	}
}
