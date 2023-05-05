package ar.edu.unq.po2.tp6.BancoYPrestamos;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	Banco unBanco;
	Solicitante unCliente;
	
	@BeforeEach
	public void setUp() {
		unCliente = new Solicitante ("Pepito", "Perez", "AV. Siempre Viva 172", 33, 15000);
	}
	
	@Test
	public void unClienteTieneNombreApellidoDireccionEdadYSueldoNetoMensual() {
		assertEquals(unCliente.getNombre(), "Pepito");
		assertEquals(unCliente.getApellido(), "Perez");
		assertEquals(unCliente.getDireccion(), "AV. Siempre Viva 172");
		assertEquals(unCliente.getEdad(), 33);
		assertEquals(unCliente.getSueldoNetoMensual(), 15000);
	}
	
	@Test
	public void elSueldoAnualDeUnClienteEsElMensualPor12() {
		assertEquals(unCliente.getSueldoNetoAnual(), 15000 * 12, 0);
	}
	
	@Test
	public void unClienteEsMenorAUnaEdadAlPasarUnaCantidadDeMeses() {
		assertTrue(unCliente.esMenorDeAlPasarNMeses(40, 12));
	}
	
	@Test
	public void unClienteNoEsMenorAUnaEdadAlPasarUnaCantidadDeMeses() {
		assertFalse(unCliente.esMenorDeAlPasarNMeses(34, 240));
	}
}
