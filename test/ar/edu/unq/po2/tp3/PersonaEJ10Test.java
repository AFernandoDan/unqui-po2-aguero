package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaEJ10Test {
	PersonaEJ10 unaPersona, otraPersona;
	
	@BeforeEach
	public void setUp() {
		unaPersona = new PersonaEJ10("Pepito", LocalDate.of(2007, 7, 18));
		otraPersona = new PersonaEJ10("Mariana", LocalDate.of(1986, 6, 11));
	}
	
	@Test
	public void laEdadDeUnaPersonaNacidaEl18DeJulioDe2007Es15Años() {
		System.out.println(unaPersona.edad());
		assertEquals(15, unaPersona.edad());
	}
	
	@Test
	public void unaPersonaNacidaEn2007EsMenorQueOtraNacidaEn1986() {
		assert(unaPersona.menorQue(otraPersona));
	}
}
