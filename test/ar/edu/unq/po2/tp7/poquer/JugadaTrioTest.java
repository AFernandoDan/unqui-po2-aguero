package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadaTrioTest {
	private Carta c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	private Set<Carta> cartas, otrasCartas;
	private Jugada jugadaPoker, jugadaColor, jugadaTrio, jugadaNada, otraJugadaTrio;
	
	@BeforeEach
	public void setUp() {
		c1 = mock(Carta.class);
		c2 = mock(Carta.class);
		c3 = mock(Carta.class);
		c4 = mock(Carta.class);
		c5 = mock(Carta.class);
		c6 = mock(Carta.class);
		c7 = mock(Carta.class);
		c8 = mock(Carta.class);
		c9 = mock(Carta.class);
		c10 = mock(Carta.class);
		
		cartas = Set.of(c1,c2,c3,c4,c5);
		otrasCartas = Set.of(c6,c7,c8,c9,c10);
		
		jugadaTrio = new JugadaTrio(cartas);
		jugadaColor = mock(JugadaColor.class);
		jugadaPoker = mock(JugadaPoker.class);
		jugadaNada = mock(JugadaNada.class);
		otraJugadaTrio = new JugadaTrio(otrasCartas);
		
		when(jugadaNada.getTipoJugada()).thenReturn(TipoJugada.Nada);
	}
	
	@Test
	public void unaJugadaTrioTieneTipoTrio() {
		assertEquals(jugadaTrio.getTipoJugada(), TipoJugada.Trio);
	}
	
	@Test
	public void unaJugadaTrioLeGanaANada() {
		jugadaNada = mock(JugadaNada.class);
		Set<Carta> cartas = mock(Set.class);
		jugadaTrio = new JugadaTrio(cartas);
		when(jugadaNada.getTipoJugada()).thenReturn(TipoJugada.Nada);
		
		assertTrue(jugadaTrio.leGanaA(jugadaNada));
		verify(jugadaNada, atLeastOnce()).getTipoJugada();
	}
	
	@Test
	public void unaJugadaTrioPierdeContraPokerYColor() {
		jugadaPoker = mock(JugadaPoker.class);
		jugadaColor = mock(JugadaColor.class);
		Set<Carta> cartas = mock(Set.class);
		jugadaTrio = new JugadaTrio(cartas);
		when(jugadaPoker.getTipoJugada()).thenReturn(TipoJugada.Poker);
		when(jugadaColor.getTipoJugada()).thenReturn(TipoJugada.Color);
		
		assertFalse(jugadaTrio.leGanaA(jugadaPoker));
		verify(jugadaPoker, atLeastOnce()).getTipoJugada();
		
		assertFalse(jugadaTrio.leGanaA(jugadaColor));
		verify(jugadaColor, atLeastOnce()).getTipoJugada();
	}
	
	@Test
	public void unaJugadaTrioGanaAOtraJugadaTrioCuandoEsTrioMasValiosoQueElOtro() {
		when(c1.getValor()).thenReturn(Valor.Q);
		when(c2.getValor()).thenReturn(Valor.Q);
		when(c3.getValor()).thenReturn(Valor.Q);
		when(c4.getValor()).thenReturn(Valor.K);
		when(c5.getValor()).thenReturn(Valor.K);
			
		when(c6.getValor()).thenReturn(Valor.J);
		when(c7.getValor()).thenReturn(Valor.J);
		when(c8.getValor()).thenReturn(Valor.J);
		when(c9.getValor()).thenReturn(Valor.DOS);
		when(c10.getValor()).thenReturn(Valor.DOS);
		
		assertTrue(jugadaTrio.leGanaA(otraJugadaTrio));
	}
	
	@Test
	public void unaJugadaTrioNoGanaAOtraJugadaTrioCuandoNOEsTrioMasValiosoQueElOtro() {
		when(c1.getValor()).thenReturn(Valor.Q);
		when(c2.getValor()).thenReturn(Valor.Q);
		when(c3.getValor()).thenReturn(Valor.Q);
		when(c4.getValor()).thenReturn(Valor.K);
		when(c5.getValor()).thenReturn(Valor.K);
			
		when(c6.getValor()).thenReturn(Valor.AS);
		when(c7.getValor()).thenReturn(Valor.AS);
		when(c8.getValor()).thenReturn(Valor.AS);
		when(c9.getValor()).thenReturn(Valor.DOS);
		when(c10.getValor()).thenReturn(Valor.DOS);
		
		assertFalse(jugadaTrio.leGanaA(otraJugadaTrio));
	}
}
