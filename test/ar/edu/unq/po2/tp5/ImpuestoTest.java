package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImpuestoTest {
	private Impuesto unImpuesto;
	
	@BeforeEach
	public void setUp() {
		unImpuesto = new Impuesto("IRPF", 100);
	}
	
	@Test
	public void elMontoAPagarDeUnImpuestoEsLaTasaDelServicio() {
		assertEquals(100, unImpuesto.getTasaDelServicio());
		assertEquals(100, unImpuesto.getMontoAPagar());
	}
}
