package ar.edu.unq.po2.tpStreamsYEnums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LesionDermatologicaTest {

	@Test
	public void unColorLesionTieneDescripcion() {
		String descRojo = "Lesión inflamada o irritada",
				descMiel = "Lesión con costra o cicatrización",
				descAmarillo = "Lesión con pus o infección",
				descGris = "Lesión curada o en proceso de curación";
		
		assertEquals(ColorLesion.ROJO.getDescripcion(), descRojo);
		assertEquals(ColorLesion.GRIS.getDescripcion(), descGris);
		assertEquals(ColorLesion.AMARILLO.getDescripcion(), descAmarillo);
		assertEquals(ColorLesion.MIEL.getDescripcion(), descMiel);
	}
	
	@Test
	public void unColorLesionTieneSuSiguiente() {
		assertEquals(ColorLesion.ROJO.getSiguiente(), ColorLesion.GRIS);
		assertEquals(ColorLesion.GRIS.getSiguiente(), ColorLesion.AMARILLO);
		assertEquals(ColorLesion.AMARILLO.getSiguiente(), ColorLesion.MIEL);
		assertEquals(ColorLesion.MIEL.getSiguiente(), ColorLesion.ROJO);
	}
	
	@Test
	public void unColorLesionTieneUnNivelDeRiesgo() {
		assertEquals(ColorLesion.ROJO.getNivelDeRiesgo(), 4);
		assertEquals(ColorLesion.GRIS.getNivelDeRiesgo(), 1);
		assertEquals(ColorLesion.AMARILLO.getNivelDeRiesgo(), 3);
		assertEquals(ColorLesion.MIEL.getNivelDeRiesgo(), 2);
	}
}
