package ar.edu.unq.po2.tpObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpObserver.appPartidos.Partido;

public class PartidoTest {
	private Partido unPartido;

	@Before
	public void setUp() {
		List<String> contrincantes = Arrays.asList("Boca Juniors", "River Plate");
		unPartido = new Partido("Futbol", contrincantes, "3-0");
	}
	
	@Test
	public void unPartidoTieneUnDeporte() {
		assertEquals(unPartido.getDeporte(), "Futbol");
	}
	
	@Test
	public void unPartidoTieneContrincantes() {
		List<String> contrincantesEsperados = Arrays.asList("Boca Juniors", "River Plate");
		assertEquals(unPartido.getContrincantes(), contrincantesEsperados);
	}
	
	@Test
	public void unPartidoTieneUnResultado() {
		assertEquals(unPartido.getResultado(), "3-0");
	}
}
