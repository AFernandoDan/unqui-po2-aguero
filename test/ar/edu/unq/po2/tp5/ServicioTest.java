package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicioTest {
	private Servicio unServicio;
	private float costoPorUnidad;
	private int unidadesConsumidas;
	
	@BeforeEach
	public void setUp() {
		costoPorUnidad = 100;
		unidadesConsumidas = 3;
		unServicio = new Servicio("Netflix", costoPorUnidad, unidadesConsumidas);
	}
	
	@Test
	public void elMontoAPagarDeUnImpuestoEsLaTasaDelServicio() {
		float montoEsperado = costoPorUnidad*unidadesConsumidas;
		assertEquals(montoEsperado, unServicio.getMontoAPagar());
	}
}
