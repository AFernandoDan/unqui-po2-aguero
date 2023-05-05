package ar.edu.unq.po2.tp4.trabajador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class TrabajadorTest {
	Trabajador unTrabajador;
	IngresoGenerico unIngreso;
	IngresoGenerico unIngresoPorHorasExtra;
	
	@BeforeEach
	public void setUp() {
		unTrabajador = new Trabajador();
		unIngreso = new Ingreso("Enero", "un concepto", 3000);
		unIngresoPorHorasExtra = new IngresoPorHorasExtra("Enero", "un concepto", 3000, 4);
		unTrabajador.agregarIngreso(unIngreso);
	}
	
	public void probandoTotalPercibidoMontoImponibleYTotalAPagar() {
		assertEquals(6000, unTrabajador.getTotalPercibido());
		assertEquals(3000, unTrabajador.getMontoImponible());
		assertEquals(60, unTrabajador.getImpuestoAPagar());
	}
}
