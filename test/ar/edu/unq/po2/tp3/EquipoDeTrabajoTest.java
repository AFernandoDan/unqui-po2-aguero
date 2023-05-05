package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipoDeTrabajoTest {
	
	private EquipoDeTrabajo equipo;
	
	@BeforeEach
	public void setUp() {
		equipo = new EquipoDeTrabajo("Equipo 1");
		
		Persona p1 = new Persona("Juan", "Perez", 32);
		Persona p2 = new Persona("Maria", "Suarez", 28);
		Persona p3 = new Persona("Pedro", "Sosa", 38);
		Persona p4 = new Persona("Luisa", "Cava", 31);
		Persona p5 = new Persona("Miguel", "Franco", 25);
		
		equipo.addIntegrante(p1);
		equipo.addIntegrante(p2);
		equipo.addIntegrante(p3);
		equipo.addIntegrante(p4);
		equipo.addIntegrante(p5);
	}
	
	@Test
	public void unEquipoRecienCreado() {
		assertEquals("Equipo 1", equipo.getNombre());
	}
	
	@Test
	public void unEquipoTieneUnPromedioDeEdadDe30() {
		assertEquals(30, equipo.promedioEdadIntegrantes());
	}
}