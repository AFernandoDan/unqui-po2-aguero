package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	
	private Factura unaFactura;
	
	@BeforeEach
	public void setUp() {
		unaFactura = new Servicio("Netflix", 100, 3);
	}
	
	@Test
	public void unaFacturaTieneNombre() {
		assertEquals("Netflix", unaFactura.getNombre());
	}
	
	@Test
	public void unaFacturaTieneNombreYUnMontoAPagar() {
		assertEquals(300, unaFactura.getMontoAPagar());
	}
}
