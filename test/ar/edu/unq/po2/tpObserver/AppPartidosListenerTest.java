package ar.edu.unq.po2.tpObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpObserver.appPartidos.AppMovil;
import ar.edu.unq.po2.tpObserver.appPartidos.AppPartidos;
import ar.edu.unq.po2.tpObserver.appPartidos.AppPartidosListener;
import ar.edu.unq.po2.tpObserver.appPartidos.ServidorListener;

public class AppPartidosListenerTest {
	private ServidorListener appPartidosListener;
	private AppPartidos appPartidos;

	@BeforeEach
	public void setUp() {
		appPartidos = mock(AppPartidos.class);
		appPartidosListener = new ServidorListener(appPartidos);
	}
	
	@Test
	public void unaAppPartidosListenerConoceUnaAppDePartidos() {
		assertEquals(appPartidosListener.getAppPartidos(), appPartidos);
	}
	
	@Test
	public void unaAppMovilSePuedeSuscribirAUnDeporteEnLaAppDePartidos() {
		appPartidosListener.suscribirseADeporte("Futbol");
		verify(appPartidos).suscribirADeporte("Futbol", appPartidosListener);
	}
}
