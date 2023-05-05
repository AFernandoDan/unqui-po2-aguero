package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class JugadaTest {
	private Set<Carta> cartas;
	private Jugada jugadaPoker, jugadaCualquiera;
	private Carta c1, c2, c3, c4, c5;

	@Before
	public void setUp() {
		c1 = mock(Carta.class);
		c2 = mock(Carta.class);
		c3 = mock(Carta.class);
		c4 = mock(Carta.class);
		c5 = mock(Carta.class);
		
		cartas = Set.of(c1, c2, c3, c4, c5);
		jugadaPoker = new JugadaPoker(cartas);
		jugadaCualquiera = new JugadaPoker(cartas);
		
		when(c1.getValor()).thenReturn(Valor.DOS);
		when(c2.getValor()).thenReturn(Valor.NUEVE);
		when(c3.getValor()).thenReturn(Valor.TRES);
		when(c4.getValor()).thenReturn(Valor.SEIS);
		when(c5.getValor()).thenReturn(Valor.CINCO);
		
	}
	
	@Test
	public void unaJugadaCualquieraTieneCartas() {
		assertEquals(jugadaCualquiera.getCartas(), cartas);
	}
	
	@Test
	public void unaJugadaTieneTipoDeJugada() {
		assertEquals(jugadaPoker.getTipoJugada(), TipoJugada.Poker);
	}
	
	@Test
	public void unaJugadaSabeCualEsSuCartaMasValiosa() {
		
		Set<Carta> cartas = Set.of(c1, c2, c3, c4, c5);
		jugadaCualquiera = new JugadaNada(cartas);
		
		assertEquals(jugadaCualquiera.getCartaMasValiosa(), c2);
		
		verify(c1, atLeastOnce()).getValor();
		verify(c2, atLeastOnce()).getValor();
		verify(c3, atLeastOnce()).getValor();
		verify(c4, atLeastOnce()).getValor();
		verify(c5, atLeastOnce()).getValor();
	}
}
