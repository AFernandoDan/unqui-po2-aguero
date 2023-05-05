package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TipoJugadaTest {
	@Test
	public void unTrioLeGanaANada() {
		assertTrue(TipoJugada.Trio.leGanaA(TipoJugada.Nada));
	}
	
	@Test
	public void unColorLeGanaATrio() {
		assertTrue(TipoJugada.Color.leGanaA(TipoJugada.Trio));
	}
	
	@Test
	public void unPokerLeGanaAColor() {
		assertTrue(TipoJugada.Poker.leGanaA(TipoJugada.Color));
	}
	
	@Test
	public void unTipoDeJugadaLeGanaAOtroEntoncesLeGanaATodosLosQueEsteLeGana() {
		assertTrue(TipoJugada.Poker.leGanaA(TipoJugada.Trio));
		assertTrue(TipoJugada.Poker.leGanaA(TipoJugada.Nada));
	}
}
