package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTest {
	Counter counter;
	
	@BeforeEach
	public void setUp() throws Exception {
		counter = new Counter();
	}
	
	@Test
	public void counterNoTieneNumerosParesNiImpares() {
		assertEquals(0, counter.cantidadDePares());
		assertEquals(0, counter.cantidadDeImpares());
	}
	
	@Test
	public void counterTieneParesEImpares () {
		counter.addNumber(1);
		counter.addNumber(2);
		counter.addNumber(3);
		counter.addNumber(4);
		assertEquals(2, counter.cantidadDePares());
		assertEquals(2, counter.cantidadDeImpares());
	}
	
	@Test
	public void counterTieneMultiplosDeUnNumeroN() {
		counter.addNumber(1);
		counter.addNumber(2);
		counter.addNumber(3);
		counter.addNumber(4);
		counter.addNumber(10);
		counter.addNumber(20);
		assertEquals(2, counter.cantidadDeMultiplosDe(10));
	}
	
	@Test
	public void numeroConMayorCantidadDeDigitosPares() {
		int[] arregloEnteros = {11,22,33,44,55,666111666,777,8181,2112};
		assertEquals(666111666, Counter.numeroConMayorCantidadDeDigitosPares(arregloEnteros));
	}
	
	@Test
	public void elMultiploMasGrandeEntreTresYNueveDelCeroAlMilEs999() {
		assertEquals(999, Counter.multiploMasGrandeDelCeroAlMilDeXEY(3, 9));
	}
	
	@Test
	public void noExisteUnNumeroMenorOIgualAMilQueSeaMultiploDeMilYTres() {
		assertEquals(-1, Counter.multiploMasGrandeDelCeroAlMilDeXEY(3, 1000));
	}
	
}
