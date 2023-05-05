package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerStatusTest {
	private Carta c1, c2, c3, c4, c5;
	private PokerStatus ps;
	
	@BeforeEach
	public void setUp() {
		c1 = mock(Carta.class);
		c2 = mock(Carta.class);
		c3 = mock(Carta.class);
		c4 = mock(Carta.class);
		c5 = mock(Carta.class);
		
		ps = new PokerStatus();
	}
	
	@Test
	public void seVerificanConjuntosDeCartasConMenosDe4CartasDeMismoValorNoHayPoker() {
		
		when(c1.getValor()).thenReturn(Valor.AS);
		when(c1.getPalo()).thenReturn(Palo.CORAZONES);

		when(c2.getValor()).thenReturn(Valor.TRES);
		when(c2.getPalo()).thenReturn(Palo.PICAS);

		when(c3.getValor()).thenReturn(Valor.DIEZ);
		when(c3.getPalo()).thenReturn(Palo.DIAMANTES);

		when(c4.getValor()).thenReturn(Valor.Q);
		when(c4.getPalo()).thenReturn(Palo.TREBOLES);

		when(c5.getValor()).thenReturn(Valor.SIETE);
		when(c5.getPalo()).thenReturn(Palo.PICAS);
		
		assertTrue(ps.verificar(c1, c2, c3, c4, c5) instanceof JugadaNada);
		
	    verify(c1, atLeastOnce()).getValor();
	    verify(c2, atLeastOnce()).getValor();
	    verify(c3, atLeastOnce()).getValor();
	    verify(c4, atLeastOnce()).getValor();
	    verify(c5, atLeastOnce()).getValor();
	}
	
	@Test
	public void seVerificaConjuntoDeCartasDondeHay4DeUnMismoValorHayPoker() {
	    
	    when(c1.getValor()).thenReturn(Valor.AS);
	    when(c1.getPalo()).thenReturn(Palo.CORAZONES);

	    when(c2.getValor()).thenReturn(Valor.AS);
	    when(c2.getPalo()).thenReturn(Palo.PICAS);

	    when(c3.getValor()).thenReturn(Valor.AS);
	    when(c3.getPalo()).thenReturn(Palo.DIAMANTES);

	    when(c4.getValor()).thenReturn(Valor.AS);
	    when(c4.getPalo()).thenReturn(Palo.TREBOLES);

	    when(c5.getValor()).thenReturn(Valor.SIETE);
	    when(c5.getPalo()).thenReturn(Palo.PICAS);
	    
	    assertTrue(ps.verificar(c1, c2, c3, c4, c5) instanceof JugadaPoker);
	    
	    verify(c1, atLeastOnce()).getValor();
	    verify(c2, atLeastOnce()).getValor();
	    verify(c3, atLeastOnce()).getValor();
	    verify(c4, atLeastOnce()).getValor();
	    verify(c5, atLeastOnce()).getValor();
	}

	@Test
	public void seVerificaConjuntoDeCartasDondeHay3DeUnMismoValorHayTrio() {

	    when(c1.getValor()).thenReturn(Valor.AS);
	    when(c1.getPalo()).thenReturn(Palo.CORAZONES);

	    when(c2.getValor()).thenReturn(Valor.AS);
	    when(c2.getPalo()).thenReturn(Palo.PICAS);

	    when(c3.getValor()).thenReturn(Valor.AS);
	    when(c3.getPalo()).thenReturn(Palo.DIAMANTES);

	    when(c4.getValor()).thenReturn(Valor.Q);
	    when(c4.getPalo()).thenReturn(Palo.TREBOLES);

	    when(c5.getValor()).thenReturn(Valor.SIETE);
	    when(c5.getPalo()).thenReturn(Palo.PICAS);
	    
	    assertTrue(ps.verificar(c1, c2, c3, c4, c5) instanceof JugadaTrio);
	    
	    verify(c1, atLeastOnce()).getValor();
	    verify(c2, atLeastOnce()).getValor();
	    verify(c3, atLeastOnce()).getValor();
	    verify(c4, atLeastOnce()).getValor();
	    verify(c5, atLeastOnce()).getValor();
	}
	
	@Test
	public void seVerificaConjuntoDeCartasDondeHay5DeUnMismoPaloColorHayColor() {
	    PokerStatus ps = new PokerStatus();
	    
	    Carta c1 = mock(Carta.class);
	    when(c1.getValor()).thenReturn(Valor.AS);
	    when(c1.getPalo()).thenReturn(Palo.CORAZONES);

	    Carta c2 = mock(Carta.class);
	    when(c2.getValor()).thenReturn(Valor.AS);
	    when(c2.getPalo()).thenReturn(Palo.CORAZONES);

	    Carta c3 = mock(Carta.class);
	    when(c3.getValor()).thenReturn(Valor.DOS);
	    when(c3.getPalo()).thenReturn(Palo.CORAZONES);

	    Carta c4 = mock(Carta.class);
	    when(c4.getValor()).thenReturn(Valor.Q);
	    when(c4.getPalo()).thenReturn(Palo.CORAZONES);

	    Carta c5 = mock(Carta.class);
	    when(c5.getValor()).thenReturn(Valor.SIETE);
	    when(c5.getPalo()).thenReturn(Palo.CORAZONES);
	    
	    assertTrue(ps.verificar(c1, c2, c3, c4, c5) instanceof JugadaColor);
	    
	    verify(c1, atLeastOnce()).getPalo();
	    verify(c2, atLeastOnce()).getPalo();
	    verify(c3, atLeastOnce()).getPalo();
	    verify(c4, atLeastOnce()).getPalo();
	    verify(c5, atLeastOnce()).getPalo();
	}

	@Test
	public void seVerificaConjuntoDeCartasDondeNoHayPokerTrioNiColor() {
	    PokerStatus ps = new PokerStatus();
	    
	    Carta c1 = mock(Carta.class);
	    when(c1.getValor()).thenReturn(Valor.AS);
	    when(c1.getPalo()).thenReturn(Palo.CORAZONES);

	    Carta c2 = mock(Carta.class);
	    when(c2.getValor()).thenReturn(Valor.DIEZ);
	    when(c2.getPalo()).thenReturn(Palo.PICAS);

	    Carta c3 = mock(Carta.class);
	    when(c3.getValor()).thenReturn(Valor.K);
	    when(c3.getPalo()).thenReturn(Palo.TREBOLES);

	    Carta c4 = mock(Carta.class);
	    when(c4.getValor()).thenReturn(Valor.Q);
	    when(c4.getPalo()).thenReturn(Palo.DIAMANTES);

	    Carta c5 = mock(Carta.class);
	    when(c5.getValor()).thenReturn(Valor.SIETE);
	    when(c5.getPalo()).thenReturn(Palo.CORAZONES);
	    
	    assertTrue(ps.verificar(c1, c2, c3, c4, c5) instanceof JugadaNada);
	    
	    verify(c1, atLeastOnce()).getValor();
	    verify(c2, atLeastOnce()).getValor();
	    verify(c3, atLeastOnce()).getValor();
	    verify(c4, atLeastOnce()).getValor();
	    verify(c5, atLeastOnce()).getValor();
	    
	}
	
}
