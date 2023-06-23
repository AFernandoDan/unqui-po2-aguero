package ar.edu.unq.po2.tpObserver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpObserver.appPartidos.AppPartidos;
import ar.edu.unq.po2.tpObserver.appPartidos.AppPartidosListener;
import ar.edu.unq.po2.tpObserver.appPartidos.Partido;

public class AppPartidosTest {
	private AppPartidos appPartidos;
	private Partido unPartido;
	private AppPartidosListener unListener;

	@Before
	public void setUp() {
		unListener = mock(AppPartidosListener.class);
		List<String> contrincantesPartido = Arrays.asList("Boca","River");
		unPartido = mock(Partido.class);
		when(unPartido.getDeporte()).thenReturn("Futbol");
		when(unPartido.getContrincantes()).thenReturn(contrincantesPartido);
		appPartidos = new AppPartidos();
	}
	
	@Test
	public void unaAppDePartidosInicialmenteNoTieneNiPartidosNiDeportesNiContrincantes() {
		assertTrue(appPartidos.getPartidos().isEmpty());
		assertTrue(appPartidos.getDeportes().isEmpty());
		assertTrue(appPartidos.getContrincantes().isEmpty());
	}
	
	@Test
	public void unaAppDePartidosPuedeCargarPartidosSiElDeporteYLosContrincantesNoEstabanSeAgregan() {
		List<String> contrincantesEsperados = Arrays.asList("Boca","River");
		appPartidos.cargarPartido(unPartido);
		assertTrue(appPartidos.getPartidos().contains(unPartido));
		assertTrue(appPartidos.estaElDeporte("Futbol"));
		assertTrue(appPartidos.getContrincantes().containsAll(contrincantesEsperados));
		verify(unPartido, times(2)).getContrincantes();
		verify(unPartido, times(2)).getDeporte();
	}
	
	@Test
	public void unaAppDePartidosPuedeSuscribirAUnDeporteAUnListenerDeLaAppSiElDeporteNoExisteLoAgrega() {
		assertFalse(appPartidos.getDeportes().contains("Futbol"));
		appPartidos.suscribirADeporte("Futbol", unListener);
		assertTrue(appPartidos.estaElDeporte("Futbol"));
	}
	
	@Test
	public void unaAppDePartidosPuedeDesuscribirDeUnDeporteAUnListenerDeLaAppPeroElDeporteSigueEstando() {
		appPartidos.suscribirADeporte("Futbol", unListener);
		appPartidos.desuscribirDeDeporte("Futbol", unListener);
		assertTrue(appPartidos.estaElDeporte("Futbol"));
		assertFalse(appPartidos.tieneSuscritoEnDeporte("Futbol", unListener));
	}
	
	@Test
	public void unaAppDePartidosPuedeSuscribirAUnContrincanteAUnListenerDeLaAppSiElContrincanteNoExisteLoAgrega() {
		assertFalse(appPartidos.getContrincantes().contains("Boca"));
		appPartidos.suscribirAContrincante("Boca", unListener);
		assertTrue(appPartidos.estaElContrincante("Boca"));
	}
	
	@Test
	public void unaAppDePartidosPuedeDesuscribirDeUnContrincanteAUnListenerDeLaAppPeroElContrincanteSigueEstando() {
		appPartidos.suscribirAContrincante("Boca", unListener);
		appPartidos.desuscribirDeContrincante("Boca", unListener);
		assertTrue(appPartidos.estaElContrincante("Boca"));
		assertFalse(appPartidos.tieneSuscritoEnContrincante("Boca", unListener));
	}
}
