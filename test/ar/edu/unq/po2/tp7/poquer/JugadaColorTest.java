package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadaColorTest {
	private JugadaTrio unaJugadaTrio;
	private JugadaNada unaJugadaNada;
	private Set<Carta> cartas;
	private JugadaColor jugadaColor, otraJugadaColor;
	private JugadaPoker unaJugadaPoker;
	private Carta c1, c2, c3, c4, c5, cartaMasValiosaOJ;

	@BeforeEach
	public void setUp() {
		unaJugadaTrio = mock(JugadaTrio.class);
		unaJugadaNada = mock(JugadaNada.class);
		cartas = mock(Set.class);
		unaJugadaPoker = mock(JugadaPoker.class);
		otraJugadaColor = mock(JugadaColor.class);
		jugadaColor = new JugadaColor(cartas);
		
		c1 = mock(Carta.class);
		c2 = mock(Carta.class);
		c3 = mock(Carta.class);
		c4 = mock(Carta.class);
		c5 = mock(Carta.class);
		cartaMasValiosaOJ = mock(Carta.class);
		
		when(c1.getValor()).thenReturn(Valor.J);
		when(c2.getValor()).thenReturn(Valor.NUEVE);
		when(c3.getValor()).thenReturn(Valor.DIEZ);
		when(c4.getValor()).thenReturn(Valor.SEIS);
		when(c5.getValor()).thenReturn(Valor.CINCO);
	}
	
	@Test
	public void unaJugadaColorLeGanaATrioYNada() {
		when(unaJugadaNada.getTipoJugada()).thenReturn(TipoJugada.Nada);
		when(unaJugadaTrio.getTipoJugada()).thenReturn(TipoJugada.Trio);
		
		assertTrue(jugadaColor.leGanaA(unaJugadaTrio));
		assertTrue(jugadaColor.leGanaA(unaJugadaNada));
		verify(unaJugadaNada).getTipoJugada();
		verify(unaJugadaTrio).getTipoJugada();
	}
	
	@Test
	public void elTipoDeUnaJugadaColorEsColor() {
		assertEquals(jugadaColor.getTipoJugada(), TipoJugada.Color);
	}
	
	@Test
	public void unaJugadaColorNoLeGanaAUnaJugadaPoker() {
		when(unaJugadaPoker.getTipoJugada()).thenReturn(TipoJugada.Poker);
		
		assertFalse(jugadaColor.leGanaA(unaJugadaPoker));
		verify(unaJugadaPoker, atLeastOnce()).getTipoJugada();
	}
	
	@Test
	public void unaJugadaColorLeGanaAOtraJugadaColorYaQueTieneCartaMasValiosaQueLaOtraJugada() {
		when(otraJugadaColor.getTipoJugada()).thenReturn(TipoJugada.Color);
		when(otraJugadaColor.getCartaMasValiosa()).thenReturn(cartaMasValiosaOJ);
		when(cartaMasValiosaOJ.getValor()).thenReturn(Valor.K);
		when(c1.tieneMasValorQue(cartaMasValiosaOJ)).thenReturn(false);
		
		Set<Carta> cartasNuevas = Set.of(c1, c2, c3, c4, c5);
		jugadaColor = new JugadaColor(cartasNuevas);
		
		assertFalse(jugadaColor.leGanaA(otraJugadaColor));
		verify(otraJugadaColor, atLeastOnce()).getTipoJugada();
		verify(otraJugadaColor, atLeastOnce()).getTipoJugada();
		verify(otraJugadaColor).getCartaMasValiosa();
		verify(c1).tieneMasValorQue(cartaMasValiosaOJ);
	}
	
	@Test
	public void unaJugadaColorNoLeGanaAOtraJugadaColorNoTieneCartaMasValiosaQueLaOtraJugada() {
		when(otraJugadaColor.getTipoJugada()).thenReturn(TipoJugada.Color);
		when(otraJugadaColor.getCartaMasValiosa()).thenReturn(cartaMasValiosaOJ);
		when(cartaMasValiosaOJ.getValor()).thenReturn(Valor.K);
		when(c5.getValor()).thenReturn(Valor.AS);
		when(c5.tieneMasValorQue(cartaMasValiosaOJ)).thenReturn(true);
		
		Set<Carta> cartasNuevas = Set.of(c1, c2, c3, c4, c5);
		jugadaColor = new JugadaColor(cartasNuevas);
		
		assertTrue(jugadaColor.leGanaA(otraJugadaColor));
		verify(otraJugadaColor, atLeastOnce()).getTipoJugada();
		verify(otraJugadaColor, atLeastOnce()).getTipoJugada();
		verify(otraJugadaColor).getCartaMasValiosa();
		verify(c5).tieneMasValorQue(cartaMasValiosaOJ);
	}
}
