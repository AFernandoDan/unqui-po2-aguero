package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValorTest {
	@Test
	public void unValorEsMayorAOtro() {
		assertTrue(Valor.AS.esMayorQue(Valor.K));
		assertTrue(Valor.Q.esMayorQue(Valor.DIEZ));
	}
}