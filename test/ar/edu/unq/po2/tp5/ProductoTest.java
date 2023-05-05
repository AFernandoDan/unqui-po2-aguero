package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {
	private Producto unProducto;
	
	@BeforeEach
	public void setUp() {
		unProducto = new ProductoTradicional("CocaCola", 100f, 5);
	}

	@Test
	public void unProductoNuevoTieneNombrePrecioYStock() {
		assertEquals("CocaCola", unProducto.getNombre());
		assertEquals(100, unProducto.getPrecio());
		assertEquals(5, unProducto.getStock());
	}
}
