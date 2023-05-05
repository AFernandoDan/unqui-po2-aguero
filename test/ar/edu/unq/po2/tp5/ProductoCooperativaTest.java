package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoCooperativaTest {
	
	private Producto unProducto;
	
	@BeforeEach
	public void setUp() {
		unProducto = new ProductoCooperativa("Papas PEPE", 100f, 5);
	}

	@Test
	public void elPrecioDeUnProductoEsEl90PorcientoDeSuPrecioBase() {
		float precioEsperado = 90f;
		assertEquals(precioEsperado, unProducto.getPrecio());
	}
}
