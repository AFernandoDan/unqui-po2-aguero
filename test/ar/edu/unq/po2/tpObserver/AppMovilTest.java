package ar.edu.unq.po2.tpObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpObserver.appPartidos.AppMovil;
import ar.edu.unq.po2.tpObserver.appPartidos.AppPartidos;

public class AppMovilTest {
	AppMovil appMovil;
	AppPartidos appPartidos;
	
	@BeforeEach
	public void setUp() {
		appPartidos = mock(AppPartidos.class);
		appMovil = new AppMovil(appPartidos);
	}
	
	@Test
	public void unaAppMovilConoceUnaAppDePartidos() {
		assertEquals(appMovil.getAppPartidos(), appPartidos);
	}

	@Test
	public void unaAppMovilSePuedeSuscribirAUnContrincanteEnLaAppDePartidos() {
		appMovil.suscribirseAContrincante("Boca Juniors");
		verify(appPartidos).suscribirAContrincante("Boca Juniors", appMovil);
	}
}
