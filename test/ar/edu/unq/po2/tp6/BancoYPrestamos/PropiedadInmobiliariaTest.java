package ar.edu.unq.po2.tp6.BancoYPrestamos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PropiedadInmobiliariaTest {
	@Test
	public void unaPropiedadInmobiliariaTieneUnaDescripcionUnaDireccionYValorFiscal() {
		PropiedadInmobiliaria propiedad = new PropiedadInmobiliaria("Casa", "Av. 9 de Julio 172", 30000);
		assertEquals(propiedad.getDescripcion(), "Casa");
		assertEquals(propiedad.getDireccion(), "Av. 9 de Julio 172");
		assertEquals(propiedad.getValorFiscal(), 30000);
	}
}
