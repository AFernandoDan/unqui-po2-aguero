package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiOperadorTest {
	ArrayList<Integer> enteros;
	MultiOperador unMultiOperador;
	
	@BeforeEach
	public void setUp() throws Exception {
		unMultiOperador = new MultiOperador();
		
		enteros = new ArrayList<Integer>(10);  
		enteros.add(1);
		enteros.add(2);
		enteros.add(3);
		enteros.add(4);
		enteros.add(5);
		enteros.add(-3);
	}
	
	@Test
	public void multiOperadorSumaRestaYMultiplicaNumerosDeUnArrayList() {
		assertEquals(12, unMultiOperador.sumar(enteros));
		assertEquals(-12, unMultiOperador.restar(enteros));
		assertEquals(-360, unMultiOperador.multiplicar(enteros));
	}
}
