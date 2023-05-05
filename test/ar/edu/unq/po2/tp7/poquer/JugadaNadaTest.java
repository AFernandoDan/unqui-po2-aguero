package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadaNadaTest {
	private Set<Carta> cartas;
	private JugadaNada unaJugadaNada, otraJugadaNada;
	private Jugada jugadaConPuntaje;
	private Carta c1, c2, c3, c4, c5, cartaMasValiosaOJ;
	
	@BeforeEach
	public void setUp() {
		c1 = mock(Carta.class);
		c2 = mock(Carta.class);
		c3 = mock(Carta.class);
		c4 = mock(Carta.class);
		c5 = mock(Carta.class);
		
		when(c1.getValor()).thenReturn(Valor.DOS);
		when(c2.getValor()).thenReturn(Valor.NUEVE);
		when(c3.getValor()).thenReturn(Valor.J);
		when(c4.getValor()).thenReturn(Valor.SEIS);
		when(c5.getValor()).thenReturn(Valor.CINCO);
		
		cartas = Set.of(c1, c2, c3, c4, c5);
		
		cartaMasValiosaOJ = mock(Carta.class);
		unaJugadaNada = new JugadaNada(cartas);
		jugadaConPuntaje = mock(JugadaPoker.class);
		when(jugadaConPuntaje.getTipoJugada()).thenReturn(TipoJugada.Poker);
		otraJugadaNada = mock(JugadaNada.class);

	}
	
	@Test
	public void unaJugadaQueNoTieneNadaNoLeGanaAOtrasQueTienenPuntaje() {
		assertFalse(unaJugadaNada.leGanaA(jugadaConPuntaje));
		verify(jugadaConPuntaje, atLeastOnce()).getTipoJugada();
	}
	
	@Test
	public void unaJugadaQueNoTieneNadaLeGanaAOtraQueNoTieneNadaPorqueTieneUnaCartaDeMayorValor() {
		when(c3.tieneMasValorQue(cartaMasValiosaOJ)).thenReturn(true);
		
		when(otraJugadaNada.getCartaMasValiosa()).thenReturn(cartaMasValiosaOJ);
		when(otraJugadaNada.getTipoJugada()).thenReturn(TipoJugada.Nada);
		
		assertTrue(unaJugadaNada.leGanaA(otraJugadaNada));
		verify(c3, atMostOnce()).tieneMasValorQue(cartaMasValiosaOJ);
		verify(otraJugadaNada, atMostOnce()).getCartaMasValiosa();
		verify(otraJugadaNada, atMostOnce()).getTipoJugada();
	}
	
	@Test
	public void unaJugadaQueNoTieneNadaNoLeGanaAOtraQueNoTieneNadaPorqueNoTieneUnaCartaDeMayorValor() {
		when(otraJugadaNada.getTipoJugada()).thenReturn(TipoJugada.Nada);
		when(otraJugadaNada.getCartaMasValiosa()).thenReturn(cartaMasValiosaOJ);
		when(c3.tieneMasValorQue(cartaMasValiosaOJ)).thenReturn(false);
		
		Set<Carta> cartas = Set.of(c1, c2, c3, c4, c5);
		unaJugadaNada = new JugadaNada(cartas);
		
		assertFalse(unaJugadaNada.leGanaA(otraJugadaNada));
		
		verify(otraJugadaNada).getTipoJugada();
		verify(otraJugadaNada).getCartaMasValiosa();
	}
	
	@Test
	public void unaJugadaNadaTieneTipoNada() {
		assertEquals(unaJugadaNada.getTipoJugada(), TipoJugada.Nada);
	}
}
