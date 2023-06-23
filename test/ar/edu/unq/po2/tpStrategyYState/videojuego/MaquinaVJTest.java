package ar.edu.unq.po2.tpStrategyYState.videojuego;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpStrategyYState.videojuegos.MaquinaVJ;
import ar.edu.unq.po2.tpStrategyYState.videojuegos.StateMaquinaVJ;
import ar.edu.unq.po2.tpStrategyYState.videojuegos.StateMaquinaVJDosFichasIngresadas;
import ar.edu.unq.po2.tpStrategyYState.videojuegos.StateMaquinaVJFichaIngresada;
import ar.edu.unq.po2.tpStrategyYState.videojuegos.StateMaquinaVJIdle;

public class MaquinaVJTest {
	private MaquinaVJ unaMaquina;
	private StateMaquinaVJIdle estadoIdle;
	private StateMaquinaVJ estadoFichaIngresada;
	private StateMaquinaVJDosFichasIngresadas estadoDosFichasIngresadas;
	
	@Before
	public void setUp() {
		estadoIdle = mock(StateMaquinaVJIdle.class);
		estadoFichaIngresada = mock(StateMaquinaVJFichaIngresada.class);
		estadoDosFichasIngresadas = mock(StateMaquinaVJDosFichasIngresadas.class);
		unaMaquina = new MaquinaVJ(estadoIdle);
		
		// comportamiento estadoIdle
		doAnswer(invocation -> {
			unaMaquina.setState(estadoFichaIngresada);
			return null;
		}).when(estadoIdle).ingresarFicha(unaMaquina);
		
		doAnswer(invocation -> {
			return null;
		}).when(estadoIdle).presionarBoton(unaMaquina);
		
		// comportamiento estadoFichaIngresada
		doAnswer(invocation -> {
			unaMaquina.setState(estadoDosFichasIngresadas);
			return null;
		}).when(estadoFichaIngresada).ingresarFicha(unaMaquina);
		
		doAnswer(invocation -> {
			unaMaquina.setState(estadoIdle);
			return null;
		}).when(estadoFichaIngresada).presionarBoton(unaMaquina);
		
		// comportamiento estadoDosFichasIngresadas
		
		doAnswer(invocation -> {
			return null;
		}).when(estadoDosFichasIngresadas).ingresarFicha(unaMaquina);
		
		doAnswer(invocation -> {
			unaMaquina.setState(estadoIdle);
			return null;
		}).when(estadoDosFichasIngresadas).presionarBoton(unaMaquina);
	}

	@Test
	public void unaMaquinaNuevaEstaEnEstadoIdle() {
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJIdle);
	}
	
	@Test
	public void cuandoSeIntroduceUnaFichaEstandoEnEstadoIdleCambiaAEstadoFichaIngresada() {
		unaMaquina.ingresarFicha();
		verify(estadoIdle).ingresarFicha(unaMaquina);
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJFichaIngresada);
	}
	
	@Test
	public void cuandoSePresionaElBotonEstandoEnIdleElEstadoNoCambia() {
		unaMaquina.presionarBoton();
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJIdle);
		verify(estadoIdle).presionarBoton(unaMaquina);
	}
	
	@Test
	public void cuandoSeIntroduceUnaFichaEnEstadoFichaIngresadaCambiaADosFichasIngresadas() {
		unaMaquina.ingresarFicha();
		
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJFichaIngresada);
		
		unaMaquina.ingresarFicha();
		
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJDosFichasIngresadas);
		verify(estadoIdle).ingresarFicha(unaMaquina);
		verify(estadoFichaIngresada).ingresarFicha(unaMaquina);
	}
	
	@Test
	public void cuandoSePresionaElBotonEnEstadoDeFichaIngresadaEsteVuelveAIdle() {
		unaMaquina.ingresarFicha();
		unaMaquina.presionarBoton();
		
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJIdle);
		verify(estadoFichaIngresada).presionarBoton(unaMaquina);
	}
	
	@Test
	public void cuandoSePresionaElBotonEnEstadoDeDosFichasIngresadasEsteVuelveAIdle() {
		unaMaquina.ingresarFicha();
		unaMaquina.ingresarFicha();
		unaMaquina.presionarBoton();
		
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJIdle);
		verify(estadoDosFichasIngresadas).presionarBoton(unaMaquina);
	}
	
	@Test
	public void cuandoSeIntroduceUnaFichaHabiendoIntroducidoDosElEstadoNoCambia() {
		unaMaquina.ingresarFicha();
		unaMaquina.ingresarFicha();
		unaMaquina.ingresarFicha();
		
		assertTrue(unaMaquina.getState() instanceof StateMaquinaVJDosFichasIngresadas);
		verify(estadoDosFichasIngresadas).ingresarFicha(unaMaquina);
	}
}