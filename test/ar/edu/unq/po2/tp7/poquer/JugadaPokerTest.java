package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JugadaPokerTest {
	
	private Set<Carta> cartas, otrasCartas;
	private Jugada jp, jc, jt, jn, ojp;
	private Carta c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	
	@Before
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
		
		jp = new JugadaPoker(cartas);
		jc = mock(JugadaColor.class);
		jt = mock(JugadaTrio.class);
		jn = mock(JugadaNada.class);
		ojp = new JugadaPoker(otrasCartas);
	}

	@Test
	public void unaJugadaPokerLeGanaAColorTrioYNada() {
		when(jc.getTipoJugada()).thenReturn(TipoJugada.Color);
		when(jt.getTipoJugada()).thenReturn(TipoJugada.Trio);
		when(jn.getTipoJugada()).thenReturn(TipoJugada.Nada);
		
		assertTrue(jp.leGanaA(jc));
		assertTrue(jp.leGanaA(jt));
		assertTrue(jp.leGanaA(jn));
		
	    verify(jc, atLeastOnce()).getTipoJugada();
	    verify(jt, atLeastOnce()).getTipoJugada();
	    verify(jn, atLeastOnce()).getTipoJugada();
	}
	
	@Test
	public void unaJugadaPokerDeKsVaAlDesempateConOtraJugadaPokerDeAsesNoGanaPorQueLaOtraTieneMasValor() {
		when(c1.getValor()).thenReturn(Valor.K);
		when(c2.getValor()).thenReturn(Valor.K);
		when(c3.getValor()).thenReturn(Valor.K);
		when(c4.getValor()).thenReturn(Valor.K);
		when(c5.getValor()).thenReturn(Valor.SEIS);
			
		when(c6.getValor()).thenReturn(Valor.AS);
		when(c7.getValor()).thenReturn(Valor.AS);
		when(c8.getValor()).thenReturn(Valor.AS);
		when(c9.getValor()).thenReturn(Valor.AS);
		when(c10.getValor()).thenReturn(Valor.DOS);
		
		assertFalse(jp.leGanaA(ojp));
		
	    verify(c1, atLeastOnce()).getValor();
	    verify(c2, atLeastOnce()).getValor();
	    verify(c3, atLeastOnce()).getValor();
	    verify(c4, atLeastOnce()).getValor();
	    verify(c5, atLeastOnce()).getValor();
	    verify(c6, atLeastOnce()).getValor();
	    verify(c7, atLeastOnce()).getValor();
	    verify(c8, atLeastOnce()).getValor();
	    verify(c9, atLeastOnce()).getValor();
	    verify(c10, atLeastOnce()).getValor();
	}
	
	@Test
	public void unaJugadaPokerDeJsVaAlDesempateConOtraJugadaPokerDeQsNoGanaPorQueLaOtraTieneMasValor() {
		when(c1.getValor()).thenReturn(Valor.J);
		when(c2.getValor()).thenReturn(Valor.J);
		when(c3.getValor()).thenReturn(Valor.J);
		when(c4.getValor()).thenReturn(Valor.J);
		when(c5.getValor()).thenReturn(Valor.K);
			
		when(c6.getValor()).thenReturn(Valor.Q);
		when(c7.getValor()).thenReturn(Valor.Q);
		when(c8.getValor()).thenReturn(Valor.Q);
		when(c9.getValor()).thenReturn(Valor.Q);
		when(c10.getValor()).thenReturn(Valor.DOS);
		
		assertFalse(jp.leGanaA(ojp));
	}
	
	@Test
	public void unaJugadaPokerTieneTipoPoker() {
		assertEquals(jp.getTipoJugada(), TipoJugada.Poker);
	}
}
