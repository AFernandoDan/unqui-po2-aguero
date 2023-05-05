package ar.edu.unq.po2.tp6.BancoYPrestamos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SolicitudCreditoPersonalTest {
	
	private SolicitudDeCredito unaSolicitud;
	private Solicitante solicitante;
	
	@Test
	public void elSueldoAnualDeUnClienteEsMenorA15000SuSolicitudNoEsAceptable() {
		solicitante = new Solicitante("Pepito", "Perez", "AV. Siempre Viva 172", 33, 1000);
		unaSolicitud = new SolicitudCreditoPersonal(15000, 6, solicitante);
		assertFalse(unaSolicitud.esAceptable());
	}
	
	@Test
	public void laCuotaSuperaEl70PorcientoDeSuSueldoMensualLaSolicitudNoEsAceptable() {
		solicitante = new Solicitante("Pepito", "Perez", "AV. Siempre Viva 172", 33, 5000);
		unaSolicitud = new SolicitudCreditoPersonal(21001, 6, solicitante);
		assertFalse(unaSolicitud.esAceptable());
	}
	
	@Test
	public void laCuotaDeLaSolicitudDeUnClienteNoSuperaEl70PorcientoDeSusIngresosMensualesYEsteEsMayorA15000EsAceptable() {
		solicitante = new Solicitante("Pepito", "Perez", "AV. Siempre Viva 172", 33, 15000);
		unaSolicitud = new SolicitudCreditoPersonal(15000, 6, solicitante);
		assertTrue(unaSolicitud.esAceptable());
	}
	
}
