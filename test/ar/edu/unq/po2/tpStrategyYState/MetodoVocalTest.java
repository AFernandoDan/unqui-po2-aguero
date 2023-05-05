package ar.edu.unq.po2.tpStrategyYState;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MetodoVocalTest {
	private MetodoVocal mVocal;

	@BeforeEach
	public void setUp() {
		mVocal = new MetodoVocal();
	}
	
	@Test
	public void elMetodoVocalEncriptaUnTextoSinVocales() {
		String texto = "s l trstz l q dj vr l lz";
		
		assertEquals(texto, mVocal.encriptar(texto));
	}
	
	@Test
	public void elMetodoVocalDesncriptaUnTextoSinVocales() {
		String texto = "s l trstz l q dj vr l lz";
		
		assertEquals(texto, mVocal.desencriptar(texto));
	}
	
	@Test
	public void elMetodoVocalEncriptaUnTextoConVocales() {
		String texto = "es la tristeza la que deja ver la luz",
			textoEncriptado = "is le trostize le qai dije vir le laz";
		
		assertEquals(textoEncriptado, mVocal.encriptar(texto));
	}
	
	@Test
	public void elMetodoVocalDesencriptaUnTextoConVocales() {
		String textoDesencriptado = "es la tristeza la que deja ver la luz",
				texto = "is le trostize le qai dije vir le laz";
		
		assertEquals(textoDesencriptado, mVocal.desencriptar(texto));
	}
}
