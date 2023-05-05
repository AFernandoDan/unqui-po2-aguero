package ar.edu.unq.po2.tp6.BancoYPrestamos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolicitudCreditoHipotecarioTest {
	private SolicitudCreditoHipotecario unaSolicitud;
	private Solicitante solicitante, solicitanteJoven;
	private PropiedadInmobiliaria propiedad;
	
	@BeforeEach
	public void setUp() {
		solicitante = new Solicitante("Pepito", "Perez", "AV. Siempre Viva 172", 65, 15000);
		propiedad = new PropiedadInmobiliaria("Casa", "Av. 9 de Julio 172", 30000);
		unaSolicitud = new SolicitudCreditoHipotecario(15000, 6, solicitante, propiedad);
		solicitanteJoven = new Solicitante("Pepito", "Perez", "AV. Siempre Viva 172", 30, 15000);
	}
	
	@Test
	public void unaSolicitudDeCreditoHipotecariaTieneUnaPropiedadInmobiliariaComoGarantia() {
		assertEquals(unaSolicitud.getPropiedadGarantia(), propiedad);
	}
	
	@Test
	public void elSolicitanteSuperaLos65AntesDeTerminarDePagarElCreditoNoEsAceptable() {
		assertFalse(unaSolicitud.esAceptable());
	}
	
	@Test
	public void elMontoDeLaCuotaDeLaSolicitudSuperaEl50PorcientoDeLosIngresosMensualesDelSolicintanteNoEsAceptable() {
		
		unaSolicitud = new SolicitudCreditoHipotecario(80000, 10, solicitanteJoven, propiedad);
		assertFalse(unaSolicitud.esAceptable());
	}
	
	@Test
	public void elMontoSolicitadoSuperaEl70PorcientoDelValorDeLaGarantiaDelSolicitanteNoEsAceptable() {
		unaSolicitud = new SolicitudCreditoHipotecario(22000, 10, solicitanteJoven, propiedad);
		assertFalse(unaSolicitud.esAceptable());
	}
	
	@Test
	public void laSolicitudDeUnClienteEsAceptable() {
		unaSolicitud = new SolicitudCreditoHipotecario(10000, 10, solicitanteJoven, propiedad);
		assertTrue(unaSolicitud.esAceptable());
	}
}
