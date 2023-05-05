package ar.edu.unq.po2.tp4.supermercado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche, arroz;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false, 11);
		arroz = new ProductoPrimeraNecesidad("Arroz", 10d, false, 8);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(new Double(7.12), leche.getPrecio());
		assertEquals(new Double(9.2), arroz.getPrecio());
	}
}
