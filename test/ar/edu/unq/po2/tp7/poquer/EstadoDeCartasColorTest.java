package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadoDeCartasColorTest {
	private EstadoDeCartas unEstado;
	private Set<Carta> cartasSinColor;
	private Set<Carta> cartasConColor;
	private Carta c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	
	@BeforeEach
	public void setUp() {
		c1 = new Carta(Valor.AS, Palo.CORAZONES);
		c2 = new Carta(Valor.TRES, Palo.PICAS);
		c3 = new Carta(Valor.DIEZ, Palo.DIAMANTES);
		c4 = new Carta(Valor.Q, Palo.TREBOLES);
		c5 = new Carta(Valor.SIETE, Palo.PICAS);
		
		c6 = new Carta(Valor.AS, Palo.CORAZONES);
		c7 = new Carta(Valor.TRES, Palo.CORAZONES);
		c8 = new Carta(Valor.DIEZ, Palo.CORAZONES);
		c9 = new Carta(Valor.Q, Palo.CORAZONES);
		c10 = new Carta(Valor.SIETE, Palo.CORAZONES);
		
		cartasSinColor = Set.of(c1,c2,c3,c4,c5);
		cartasConColor = Set.of(c6,c7,c8,c9,c10);
		unEstado = new EstadoDeCartasColor();
	}
	
	@Test
	public void elEstadoNoEsAdecuadoCuandoLas5CartasNoSonDelMismoPalo() {
		assertFalse(unEstado.esAdecuadoPara(cartasSinColor));
	}
	
	@Test
	public void las5CartasSonDelMismoPaloElEstadoEsAdecuado() {
		assertTrue(unEstado.esAdecuadoPara(cartasConColor));
	}
}
