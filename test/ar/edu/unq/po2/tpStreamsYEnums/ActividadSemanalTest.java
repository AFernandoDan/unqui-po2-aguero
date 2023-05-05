package ar.edu.unq.po2.tpStreamsYEnums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActividadSemanalTest {
	private ActividadSemanal actividad, actividadJueves, actividadMiercoles;

	@BeforeEach
	public void setUp() {
		actividad = new ActividadSemanal(DiaDeLaSemana.LUNES, 17, 2, Deporte.FUTBOL);
		actividadJueves =
				new ActividadSemanal(DiaDeLaSemana.JUEVES, 13, 3, Deporte.TENNIS);
		actividadMiercoles =
				new ActividadSemanal(DiaDeLaSemana.MIERCOLES, 16, 2, Deporte.BASKET);
	}
	
	@Test
	public void unaActividadSemanalTieneDiaDeLaSemanaHoraInicioDuracionYDeporte() {
		assertEquals(actividad.getDia(), DiaDeLaSemana.LUNES);
		assertEquals(actividad.getHoraInicio(), 17);
		assertEquals(actividad.getDuracion(), 2);
		assertEquals(actividad.getDeporte(), Deporte.FUTBOL);
	}
	
	@Test
	public void elCostoDeUnaActividadDeLunesAMiercolesEsDe500Mas200PorLaComplejidadDelDeporte() {
		assertEquals(actividad.getCosto(), 500 + 200 * 2);
		assertEquals(actividadMiercoles.getCosto(), 500 + 200 * 2);
	}
	
	@Test
	public void elCostoDeUnaActividadDeJuevesADomingoEsDe1000Mas200PorLaComplejidadDelDeporte() {
		assertEquals(actividadJueves.getCosto(), 1000 + 200 * 3);
	}
	
	@Test
	public void unaActividadSemanalSabeConvertirseEnString() {
		assertEquals(actividadJueves.toString(), "Deporte: TENNIS. Dia: JUEVES A LAS: 13. Duración: 3 hora(s).");
		assertEquals(actividadMiercoles.toString(), "Deporte: BASKET. Dia: MIERCOLES A LAS: 16. Duración: 2 hora(s).");
	}
}
