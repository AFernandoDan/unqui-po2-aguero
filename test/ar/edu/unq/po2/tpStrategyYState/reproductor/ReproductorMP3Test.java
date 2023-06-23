package ar.edu.unq.po2.tpStrategyYState.reproductor;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class ReproductorMP3Test {
	private ReproductorMP3 rmp3;
	private StateRMP3Seleccion estadoSeleccion;
	private StateRMP3Reproduciendo estadoReproduciendo;
	private Song unaCancion;
	private StateRMP3Pausa estadoPausa;
	
	@Before
	public void setUp() {
		estadoSeleccion = mock(StateRMP3Seleccion.class);
		estadoReproduciendo = mock(StateRMP3Reproduciendo.class);
		estadoPausa = mock(StateRMP3Pausa.class);
		rmp3 = new ReproductorMP3(estadoSeleccion);
		unaCancion = mock(Song.class);
		
		// comportamiento song
		doAnswer(interacition -> {
			return null;
		}).when(unaCancion).play();
		
		doAnswer(interacition -> {
			return null;
		}).when(unaCancion).stop();
		
		// comportamiento estadoSeleccion
		doAnswer(interacition -> {
			rmp3.playWhenSelection(unaCancion, estadoReproduciendo);
			return null;
		}).when(estadoSeleccion).play(rmp3, unaCancion);
		
		// comportamiento estadoPlaying
		doAnswer(interaction -> {
			rmp3.pauseWhenPlaying(estadoPausa);
			return null;
		}).when(estadoReproduciendo).pause(rmp3);
		
		doAnswer(interaction -> {
			rmp3.stopWhenPlaying(estadoSeleccion);
			return null;
		}).when(estadoReproduciendo).stop(rmp3);
		
		// comportamiento estadoPaused
		doAnswer(interaction -> {
			rmp3.pauseWhenPaused(estadoReproduciendo);
			return null;
		}).when(estadoPausa).pause(rmp3);
	}

	@Test
	public void unReproductorNuevoEstaEnEstadoDeSeleccionYNoTieneCancionActual() {
		assertTrue(rmp3.getState() instanceof StateRMP3Seleccion);
		assertEquals(rmp3.getCurrentSong(), null);
	}
	
	@Test
	public void unReproductorPuedeCambiarSuEstadoYCancionActual() {
		StateRMP3 unEstadoCualquiera = mock(StateRMP3.class);
		rmp3.setState(unEstadoCualquiera);
		rmp3.setCurrentSong(unaCancion);
		assertEquals(rmp3.getState(), unEstadoCualquiera);
		assertEquals(rmp3.getCurrentSong(), unaCancion);
	}
	
	@Test
	public void unReproductorReproduceCuandoEstaEnSeleccion() {
		rmp3.playWhenSelection(unaCancion, estadoReproduciendo);
		assertEquals(rmp3.getCurrentSong(), unaCancion);
		assertEquals(rmp3.getState(), estadoReproduciendo);
		verify(unaCancion).play();
	}
	
	@Test
	public void unReproductorEnEstadoSeleccionReproduceUnaCancionSuEstadoCambiaAReproduciendo() {
		
		rmp3.play(unaCancion);
		
		assertEquals(rmp3.getState(), estadoReproduciendo);
		
		verify(unaCancion).play();
		verify(estadoSeleccion).play(rmp3, unaCancion);
		
	}
	
	@Test
	public void unReproductorQueNoEstaEnEstadoDeSeleccionReproduceUnaCancionDevuelveError() {
		Song otraCancion = mock(Song.class);
		String mensajeDeError = "Ya se esta reproduciendo una cancion";
		
		doAnswer(interacition -> {
			throw new Error(mensajeDeError);
		}).when(estadoReproduciendo).play(rmp3, otraCancion);
		
		rmp3.play(unaCancion);
		assertEquals(rmp3.getState(), estadoReproduciendo);
		
		
		Error error = assertThrows(Error.class, () -> {
			rmp3.play(otraCancion);
		});
		assertEquals(mensajeDeError, error.getMessage());
		verify(otraCancion, never()).play();
	}
	
	@Test
	public void seParaLaReproduccionDeUnReproductorEnReproduciendoEstePasaASeleccion() {
		rmp3.play(unaCancion);
		
		rmp3.stop();
		
		assertEquals(rmp3.getState(), estadoSeleccion);
		assertNull(rmp3.getCurrentSong());
		verify(unaCancion).stop();
		verify(estadoReproduciendo).stop(rmp3);
	}
	
	@Test
	public void seParaLaReproduccionDeUnReproductorEnUnEstadoNoReproduciendoNoHaceNada() {
		Song expectedSong = rmp3.getCurrentSong();
		StateRMP3 expectedState = rmp3.getState();
		
		rmp3.stop();
		
		assertEquals(rmp3.getCurrentSong(), expectedSong);
		assertEquals(rmp3.getState(), expectedState);
	}
	
	@Test
	public void cuandoUnReproductoEstaReproduciendoYSePausaPausaLaCancionYCambiaAPausado() {
		rmp3.play(unaCancion);
		
		rmp3.pauseWhenPlaying(estadoPausa);
		
		assertEquals(rmp3.getState(), estadoPausa);
		verify(unaCancion).pause();
	}
	
	@Test
	public void sePausaUnReproductorQueEstaReproduciendo() {
		rmp3.play(unaCancion);
		rmp3.pause();
		
		assertEquals(rmp3.getState(), estadoPausa);
		verify(unaCancion).pause();
		verify(estadoReproduciendo).pause(rmp3);
	}
	
	@Test
	public void cuandoUnReproductoEstaPausadoYSePausaReanudaLaCancionYCambiaAReproduciendo() {
		rmp3.play(unaCancion);
		rmp3.pause();
		rmp3.pause();
		
		assertEquals(rmp3.getState(), estadoReproduciendo);
		verify(unaCancion, times(2)).play();
	}
	
	@Test
	public void sePausaUnReproductorQueNoEstaReproduciendoNiEnPausaLanzaError() {
		String mensajeDeError = "Ocurrio un error al pausar";
		StateRMP3 unEstadoCualquiera = mock(StateRMP3.class);
		
		doAnswer(interacition -> {
			throw new Error(mensajeDeError);
		}).when(unEstadoCualquiera).pause(rmp3);
		
		rmp3.setState(unEstadoCualquiera);
		assertNotEquals(rmp3.getState(), estadoReproduciendo);
		assertNotEquals(rmp3.getState(), estadoPausa);
		
		
		Error error = assertThrows(Error.class, () -> {
			rmp3.pause();
		});
		assertEquals(mensajeDeError, error.getMessage());
	}
}
