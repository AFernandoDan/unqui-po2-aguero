package ar.edu.unq.po2.tpStrategyYState.encriptacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpStrategyYState.encriptacion.MetodoNumerico;

public class MetodoNumericoTest {
	private MetodoNumerico mNumerico;

	@BeforeEach
	public void setUp() {
		mNumerico = new MetodoNumerico();
	}
	
	@Test
	public void elMetodoNumericoEncriptaUnTextoConLetrasMinusculasYEspacios() {
		String texto = "es la tristeza la que deja ver la luz",
			textoEncriptado = "5, 19, 0, 12, 1, 0, 20, 18, 9, 19, 20, 5, 26, 1, 0, 12, 1, 0, 17, 21, 5, 0, 4, 5, 10, 1, 0, 22, 5, 18, 0, 12, 1, 0, 12, 21, 26";
		assertEquals(textoEncriptado, mNumerico.encriptar(texto));
	}
	
	@Test
	public void elMetodoNumericoDesncriptaUnTexto() {
		String textoDesencriptado = "es la tristeza la que deja ver la luz",
			texto = "5, 19, 0, 12, 1, 0, 20, 18, 9, 19, 20, 5, 26, 1, 0, 12, 1, 0, 17, 21, 5, 0, 4, 5, 10, 1, 0, 22, 5, 18, 0, 12, 1, 0, 12, 21, 26";
		assertEquals(textoDesencriptado, mNumerico.desencriptar(texto));
	}
	
}
