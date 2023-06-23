package ar.edu.unq.po2.tpStrategyYState.encriptacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpStrategyYState.encriptacion.MetodoOrden;

public class MetodoOrdenTest {
	private MetodoOrden unMetodoOrden;

	@BeforeEach
	public void setUp() {
		unMetodoOrden = new MetodoOrden();
	}
	
	@Test
	public void elMetodoOrdenEncriptaUnTextoVacio() {
		assertEquals("", unMetodoOrden.encriptar(""));
	}
	
	@Test
	public void elMetodoOrdenDesencriptaUnTextoVacio() {
		assertEquals("", unMetodoOrden.desencriptar(""));
	}
	
	@Test
	public void elMetodoOrdenEncriptaUnTextoConUnaPalabra() {
		assertEquals("hola", unMetodoOrden.encriptar("hola"));
	}
	
	@Test
	public void elMetodoOrdenDesncriptaUnTextoConUnaPalabra() {
		assertEquals("hola", unMetodoOrden.desencriptar("hola"));
	}
	
	@Test
	public void elMetodoOrdenEncriptaUnTextoConVariasPalabras() {
		String texto = "Nos ahogaron de razon",
			textoEsperado = "ahogaron Nos razon de";
		assertEquals(textoEsperado, unMetodoOrden.encriptar(texto));
	}
	
	@Test
	public void elMetodoOrdenDesncriptaUnTextoConVariasPalabras() {
		String texto1 = "Nos ahogaron de razon llora esa flor",
			textoEsperado1 = "ahogaron Nos razon de esa llora flor";
		assertEquals(textoEsperado1, unMetodoOrden.desencriptar(texto1));
		
		String texto2 = "ahogaron Nos razon de",
				textoEsperado2 = "Nos ahogaron de razon";
			assertEquals(textoEsperado2, unMetodoOrden.desencriptar(texto2));
	}

}
