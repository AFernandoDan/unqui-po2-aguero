package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadoDeCartasPokerTest {
	private EstadoDeCartas unEstado;
	private Set<Carta> cartasSinPoker;
	private Set<Carta> cartasConPoker;
	private Carta c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	
	@BeforeEach
	public void setUp() {
		c1 = new Carta(Valor.AS, Palo.CORAZONES);
		c2 = new Carta(Valor.TRES, Palo.PICAS);
		c3 = new Carta(Valor.DIEZ, Palo.DIAMANTES);
		c4 = new Carta(Valor.Q, Palo.TREBOLES);
		c5 = new Carta(Valor.SIETE, Palo.PICAS);
		
		c6 = new Carta(Valor.K, Palo.CORAZONES);
		c7 = new Carta(Valor.K, Palo.TREBOLES);
		c8 = new Carta(Valor.K, Palo.PICAS);
		c9 = new Carta(Valor.K, Palo.DIAMANTES);
		c10 = new Carta(Valor.SIETE, Palo.CORAZONES);
		
		cartasSinPoker = Set.of(c1,c2,c3,c4,c5);
		cartasConPoker = Set.of(c6,c7,c8,c9,c10);
		unEstado = new EstadoDeCartasPoker();
	}
	
	@Test
	public void elEstadoNoEsAdecuadoParaUnasCartasCuandoEstasNoSon4DelMismoValor() {
		assertFalse(unEstado.esAdecuadoPara(cartasSinPoker));
	}
	
	@Test
	public void elEstadoEsAdecuadoCuandoLasCartas4SonDelMismoValor() {
		assertTrue(unEstado.esAdecuadoPara(cartasConPoker));
	}
}
