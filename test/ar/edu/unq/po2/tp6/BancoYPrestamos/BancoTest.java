package ar.edu.unq.po2.tp6.BancoYPrestamos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {
	private Banco unBanco;
	private Solicitante solicitante;
	
	@BeforeEach
	public void SetUp() {
		unBanco = new Banco();
	}
	
	@Test
	public void seRegistraUnaSolicitudDeCreditoPersonal() {
		solicitante = new Solicitante("Nombre", "Apellido", "Direccion", 33, 15000);
		SolicitudCreditoPersonal unaSolicitud  = new SolicitudCreditoPersonal(15000, 6, solicitante);
		unBanco.registrarSolicitudDeCredito(unaSolicitud);
		assertTrue(unBanco.tieneSolicitudesDeCredito());
	}
	
	@Test
	public void montoADesembolsarDeUnBancoSinSolicitudesAceptablesEs0() {
		assertEquals(unBanco.cantSolicitudesAceptables(), 0);
		assertEquals(unBanco.montoADesembolsar(), 0, 0);
	}
	
	@Test
	public void montoADesembolsarDeUnBancoConSolicitudesAceptablesEsLaSumaDeLosMontosSolicitados() {
		Solicitante maria = new Solicitante("Maria", "Suarez", "AV. Siempre Viva 172", 33, 100000);
		SolicitudCreditoPersonal soliMaria  = new SolicitudCreditoPersonal(20000, 6, maria);
		unBanco.registrarSolicitudDeCredito(soliMaria);
		
		Solicitante fulanito = new Solicitante("Fulano", "Detal", "AV. Siempre Viva 172", 33, 100000);
		SolicitudCreditoPersonal soliFulano  = new SolicitudCreditoPersonal(30000, 2, fulanito);
		unBanco.registrarSolicitudDeCredito(soliFulano);
		
		assertEquals(unBanco.cantSolicitudesAceptables(), 2);
		assertEquals(unBanco.montoADesembolsar(), 50000, 0);
	}
}
