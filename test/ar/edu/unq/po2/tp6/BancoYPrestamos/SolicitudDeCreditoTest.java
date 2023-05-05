package ar.edu.unq.po2.tp6.BancoYPrestamos;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolicitudDeCreditoTest {
	
	
	private SolicitudDeCredito unaSolicitud;
	private Solicitante solicitante;

	@BeforeEach
	public void setUp() {
		solicitante = new Solicitante("Pepito", "Perez", "AV. Siempre Viva 172", 33, 15000);
		unaSolicitud = new SolicitudCreditoPersonal(15000, 6, solicitante);
	}
	
	@Test
	public void unaSolicitudDeCreditoTieneUnSolicitanteMontoYPlazoEnMeses() {
		assertEquals(unaSolicitud.getSolicitante(), solicitante);
		assertEquals(15000, unaSolicitud.getMonto(),0);
		assertEquals(unaSolicitud.getPlazo(), 6);
	}
	
	@Test
	public void unaSolicitudDeCreditoTieneUnMontoMensual() {
		assertEquals(unaSolicitud.getMontoMensual(), 2500, 0);
	}
}
