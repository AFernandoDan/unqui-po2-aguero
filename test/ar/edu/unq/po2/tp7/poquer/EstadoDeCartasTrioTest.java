package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadoDeCartasTrioTest {
	private EstadoDeCartas unEstado;
	Set<Carta> cartasSinTrio;
	private Set<Carta> cartasConTrio;
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
		c9 = new Carta(Valor.DIEZ, Palo.DIAMANTES);
		c10 = new Carta(Valor.SIETE, Palo.CORAZONES);
		
		cartasSinTrio = Set.of(c1,c2,c3,c4,c5);
		cartasConTrio = Set.of(c6,c7,c8,c9,c10);
		unEstado = new EstadoDeCartasTrio();
	}
	
	@Test
	public void elEstadoNoEsAdecuadoParaUnasCartasCuandoEstasNoSon4DelMismoValor() {
		assertFalse(unEstado.esAdecuadoPara(cartasSinTrio));
	}
	
	@Test
	public void elEstadoEsAdecuadoCuandoLasCartas4SonDelMismoValor() {
		assertTrue(unEstado.esAdecuadoPara(cartasConTrio));
	}
}
