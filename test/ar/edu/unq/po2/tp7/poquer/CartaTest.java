package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartaTest {
	private Carta unaCarta;
	
	@BeforeEach
	public void setUp() {
		unaCarta = new Carta(Valor.AS, Palo.PICAS);
	}
	
	@Test
	public void unaCartaTieneValorYPalo() {
		assertEquals(Valor.AS, unaCarta.getValor());
		assertEquals(Palo.PICAS, unaCarta.getPalo());
	}
	
	@Test
	public void unaCartaTieneDistintoPaloQueOtra() {
		Carta otraCarta = new Carta(Valor.Q, Palo.DIAMANTES);
		assertFalse(unaCarta.tieneMismoPaloQue(otraCarta));
	}
	
	@Test
	public void unaCartaTieneMismoPaloQueOtra() {
		Carta unaCartaDeMismoPalo = new Carta(Valor.K, Palo.PICAS);
		assertTrue(unaCarta.tieneMismoPaloQue(unaCartaDeMismoPalo));
	}
	
	@Test
	public void unaCartaTieneMayorQueOtra() {
		Carta otraCarta = new Carta(Valor.Q, Palo.DIAMANTES);
		assertTrue(unaCarta.tieneMasValorQue(otraCarta));
	}
}
