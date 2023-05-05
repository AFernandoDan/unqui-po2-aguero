package ar.edu.unq.po2.tpStreamsYEnums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MunicipioTest {
	Municipio muni, muniConActividades, muniConTodosLosDeportes;
	List<ActividadSemanal> actividades;
	ActividadSemanal 
		actFutbol1,
		actTennis1,
		actBasket1,
		actRunning1,
		actJabalina1,
		actFutbol2,
		actTennis2,
		actBasket2,
		actRunning2,
		actJabalina2;
	
	@BeforeEach
	public void setUp() {
		muni = new Municipio();
		muniConActividades = new Municipio();
		muniConTodosLosDeportes = new Municipio();
		
		actFutbol1 = mock(ActividadSemanal.class);
		actTennis1 = mock(ActividadSemanal.class);
		actBasket1 = mock(ActividadSemanal.class);
		actRunning1 = mock(ActividadSemanal.class);
		actJabalina1 = mock(ActividadSemanal.class);
		actFutbol2 = mock(ActividadSemanal.class);
		actTennis2 = mock(ActividadSemanal.class);
		actBasket2 = mock(ActividadSemanal.class);
		actRunning2 = mock(ActividadSemanal.class);
		actJabalina2 = mock(ActividadSemanal.class);
		
		muniConActividades.agregarActividad(actTennis1);
		muniConActividades.agregarActividad(actFutbol1);
		muniConActividades.agregarActividad(actFutbol2);
		
		muniConTodosLosDeportes.agregarActividad(actFutbol1);
		muniConTodosLosDeportes.agregarActividad(actFutbol2);
		muniConTodosLosDeportes.agregarActividad(actTennis1);
		muniConTodosLosDeportes.agregarActividad(actTennis2);
		muniConTodosLosDeportes.agregarActividad(actBasket1);
		muniConTodosLosDeportes.agregarActividad(actBasket2);
		muniConTodosLosDeportes.agregarActividad(actJabalina1);
		muniConTodosLosDeportes.agregarActividad(actJabalina2);
		muniConTodosLosDeportes.agregarActividad(actRunning1);
		muniConTodosLosDeportes.agregarActividad(actRunning2);
		
		when(actFutbol1.getDeporte()).thenReturn(Deporte.FUTBOL);
		when(actFutbol2.getDeporte()).thenReturn(Deporte.FUTBOL);
		
		when(actTennis1.getDeporte()).thenReturn(Deporte.TENNIS);
		when(actTennis2.getDeporte()).thenReturn(Deporte.TENNIS);
		
		when(actBasket1.getDeporte()).thenReturn(Deporte.BASKET);
		when(actBasket2.getDeporte()).thenReturn(Deporte.BASKET);
		
		when(actJabalina1.getDeporte()).thenReturn(Deporte.JABALINA);
		when(actJabalina2.getDeporte()).thenReturn(Deporte.JABALINA);
		
		when(actRunning1.getDeporte()).thenReturn(Deporte.RUNNING);
		when(actRunning2.getDeporte()).thenReturn(Deporte.RUNNING);
		
		when(actFutbol1.getCosto()).thenReturn(800);
		when(actFutbol2.getCosto()).thenReturn(700);
		
		when(actTennis1.getCosto()).thenReturn(1000);
		when(actTennis2.getCosto()).thenReturn(1500);
		
		when(actBasket1.getCosto()).thenReturn(1500);
		when(actBasket2.getCosto()).thenReturn(1000);
		
		when(actJabalina1.getCosto()).thenReturn(1000);
		when(actJabalina2.getCosto()).thenReturn(1500);
		
		when(actRunning1.getCosto()).thenReturn(1500);
		when(actRunning2.getCosto()).thenReturn(1000);
	}
	
	@Test
	public void unMunicipioNoTieneActividadesSemanales() {
		assertEquals(muni.getActividades(), Arrays.asList());
	}
	
	@Test
	public void unMunicipioAgregaYTieneActividadesSemanales() {
		ActividadSemanal actividad = mock(ActividadSemanal.class);
		muni.agregarActividad(actividad);
		assertEquals(muni.getActividades(), List.of(actividad));
	}
	
	@Test
	public void unMunicipioConoceSusActividadesDeFutbol() {
		
		when(actFutbol1.esDe(Deporte.FUTBOL)).thenReturn(true);
		when(actFutbol2.esDe(Deporte.FUTBOL)).thenReturn(true);
		when(actTennis1.esDe(Deporte.FUTBOL)).thenReturn(false);
		
		assertEquals(muniConActividades.getActividadesFutbol(), List.of(actFutbol1,actFutbol2));
		verify(actFutbol1).esDe(Deporte.FUTBOL);
		verify(actFutbol2).esDe(Deporte.FUTBOL);
		verify(actTennis1).esDe(Deporte.FUTBOL);
	}
	
	@Test
	public void unMunicipioSabeCualEsLaCantidadTotalDeHorasDeActividadesSemanales() {
		when(actFutbol1.getDuracion()).thenReturn(2);
		when(actFutbol2.getDuracion()).thenReturn(2);
		when(actTennis1.getDuracion()).thenReturn(3);
		
		assertEquals(muniConActividades.getHorasSemanalesDeActividades(), 7);
		verify(actFutbol1).getDuracion();
		verify(actFutbol2).getDuracion();
		verify(actTennis1).getDuracion();
	}
	
	@Test
	public void laActividadMasBarataDelMunicipioDeUnDeporteConcreto() {
		when(actFutbol1.esDe(Deporte.FUTBOL)).thenReturn(true);
		when(actFutbol2.esDe(Deporte.FUTBOL)).thenReturn(true);
		when(actTennis1.esDe(Deporte.FUTBOL)).thenReturn(false);
		
		assertEquals(muniConActividades.getActividadMasBarataDe(Deporte.FUTBOL), actFutbol2);
		
		verify(actFutbol1).getCosto();
		verify(actFutbol2).getCosto();
		verify(actTennis1, never()).getCosto();
		
		verify(actFutbol1).esDe(Deporte.FUTBOL);
		verify(actFutbol2).esDe(Deporte.FUTBOL);
		verify(actTennis1).esDe(Deporte.FUTBOL);
	}
	
	@Test
	public void laActividadMasBarataEnElMunicipioParaCadaDeporte() {
		Map<Deporte, ActividadSemanal> actividadesMasBaratas =
				new HashMap<Deporte, ActividadSemanal>();
		
		actividadesMasBaratas.put(Deporte.FUTBOL, actFutbol2);
		actividadesMasBaratas.put(Deporte.TENNIS, actTennis1);
		actividadesMasBaratas.put(Deporte.BASKET, actBasket2);
		actividadesMasBaratas.put(Deporte.JABALINA, actJabalina1);
		actividadesMasBaratas.put(Deporte.RUNNING, actRunning2);
		
		assertEquals(muniConTodosLosDeportes.getActividadesMasBaratas(), actividadesMasBaratas);
		verify(actFutbol1).getDeporte();
		verify(actFutbol2).getDeporte();
		verify(actBasket1).getDeporte();
		verify(actBasket2).getDeporte();
		verify(actRunning1).getDeporte();
		verify(actRunning2).getDeporte();
		verify(actTennis1).getDeporte();
		verify(actTennis2).getDeporte();
		verify(actJabalina1).getDeporte();
		verify(actJabalina2).getDeporte();
		
		verify(actFutbol1).getCosto();
		verify(actFutbol2).getCosto();
		verify(actBasket1).getCosto();
		verify(actBasket2).getCosto();
		verify(actRunning1).getCosto();
		verify(actRunning2).getCosto();
		verify(actTennis1).getCosto();
		verify(actTennis2).getCosto();
		verify(actJabalina1).getCosto();
		verify(actJabalina2).getCosto();
	}
	
	@Test
	public void unMunicipioImprimeTodasSusActividadesSemanales() {
		when(actFutbol1.toString()).thenReturn("Deporte: FUTBOL. Dia: JUEVES A LAS: 13. Duración: 3 hora(s).");
		when(actTennis1.toString()).thenReturn("Deporte: TENNIS. Dia: VIERNES A LAS: 14. Duración: 4 hora(s).");
		when(actBasket1.toString()).thenReturn("Deporte: BASKET. Dia: SABADO A LAS: 15. Duración: 5 hora(s).");
		when(actJabalina1.toString()).thenReturn("Deporte: JABALINA. Dia: DOMINGO A LAS: 16. Duración: 6 hora(s).");
		when(actRunning1.toString()).thenReturn("Deporte: RUNNING. Dia: LUNES A LAS: 17. Duración: 7 hora(s).");

		when(actFutbol2.toString()).thenReturn("Deporte: FUTBOL. Dia: MARTES A LAS: 18. Duración: 8 hora(s).");
		when(actTennis2.toString()).thenReturn("Deporte: TENNIS. Dia: MIERCOLES A LAS: 19. Duración: 9 hora(s).");
		when(actBasket2.toString()).thenReturn("Deporte: BASKET. Dia: JUEVES A LAS: 20. Duración: 10 hora(s).");
		when(actJabalina2.toString()).thenReturn("Deporte: JABALINA. Dia: VIERNES A LAS: 21. Duración: 11 hora(s).");
		when(actRunning2.toString()).thenReturn("Deporte: RUNNING. Dia: SABADO A LAS: 22. Duración: 12 hora(s).");

		String impresionResultante = "Actividad: Deporte: FUTBOL. Dia: JUEVES A LAS: 13. Duración: 3 hora(s).\n"
				+ "Actividad: Deporte: FUTBOL. Dia: MARTES A LAS: 18. Duración: 8 hora(s).\n"
				+ "Actividad: Deporte: TENNIS. Dia: VIERNES A LAS: 14. Duración: 4 hora(s).\n"
				+ "Actividad: Deporte: TENNIS. Dia: MIERCOLES A LAS: 19. Duración: 9 hora(s).\n"
				+ "Actividad: Deporte: BASKET. Dia: SABADO A LAS: 15. Duración: 5 hora(s).\n"
				+ "Actividad: Deporte: BASKET. Dia: JUEVES A LAS: 20. Duración: 10 hora(s).\n"
				+ "Actividad: Deporte: JABALINA. Dia: DOMINGO A LAS: 16. Duración: 6 hora(s).\n"
				+ "Actividad: Deporte: JABALINA. Dia: VIERNES A LAS: 21. Duración: 11 hora(s).\n"
				+ "Actividad: Deporte: RUNNING. Dia: LUNES A LAS: 17. Duración: 7 hora(s).\n"
				+ "Actividad: Deporte: RUNNING. Dia: SABADO A LAS: 22. Duración: 12 hora(s).";
		
		assertEquals(muniConTodosLosDeportes.imprimirActividades(), impresionResultante);
		
		// verify
//		verify(actFutbol1).toString();
//		verify(actTennis1).toString();
//		verify(actBasket1).toString();
//		verify(actJabalina1).toString();
//		verify(actRunning1).toString();
//
//		verify(actFutbol2).toString();
//		verify(actTennis2).toString();
//		verify(actBasket2).toString();
//		verify(actJabalina2).toString();
//		verify(actRunning2).toString();
	}
}
