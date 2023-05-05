package ar.edu.unq.po2.tp7.poquer;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadoDeCartasNuloTest {
	private EstadoDeCartas unEstado;
	private Set<Carta> cartas;
	private Carta c1, c2, c3, c4, c5;
	
	@BeforeEach
	public void setUp() {
		c1 = new Carta(Valor.AS, Palo.CORAZONES);
		c2 = new Carta(Valor.TRES, Palo.PICAS);
		c3 = new Carta(Valor.DIEZ, Palo.DIAMANTES);
		c4 = new Carta(Valor.Q, Palo.TREBOLES);
		c5 = new Carta(Valor.SIETE, Palo.PICAS);
		
		cartas = Set.of(c1, c2, c3, c4, c5);
		unEstado = new EstadoDeCartasNada();
	}
	
	@Test
	public void porDefectoCualquierListasEsAdecuadoParaElEstadoNulo() {
		assertTrue(unEstado.esAdecuadoPara(cartas));
	}
}
