package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonaEJ10 {
	private String nombre;
	private LocalDate fechaDeNacimiento;
	
	PersonaEJ10(String nombre, LocalDate fechaDeNacimiento) {
		setNombreFechaDeNacimiento(nombre, fechaDeNacimiento);
	}
	
	private void setNombreFechaDeNacimiento(String nombre, LocalDate fechaDeNacimiento) {
		setNombre(nombre);
		setFechaDeNacimiento(fechaDeNacimiento);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public boolean menorQue(PersonaEJ10 persona) {
		return edad() < persona.edad();
	}

	public int edad() {
		return (int) ChronoUnit.YEARS.between(getFechaDeNacimiento(), LocalDate.now());
//		return new Date().getYear() - fechaDeNacimiento.getYear();
	}
	
	
}
