package ar.edu.unq.po2.tpRefactorings.automotor;

import java.time.LocalDate;
import java.time.Period;

public class Vehiculo {
	private Boolean esVehiculoPolicial;
	private LocalDate fechaFabricacion;	
	private String ciudadRadicacion; 
	
	public Vehiculo(Boolean esVehiculoPolicial, LocalDate fechaFabricacion, String ciudadRadicacion) {
		this.esVehiculoPolicial = esVehiculoPolicial;
		this.fechaFabricacion = fechaFabricacion;
		this.ciudadRadicacion = ciudadRadicacion;
	}

	public Boolean esVehiculoPolicial() {
		return esVehiculoPolicial;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public String ciudadRadicacion() {
		return ciudadRadicacion;
	}

	public int aniosDeAnitiguedad() {
		Period periodo = getFechaFabricacion().until(LocalDate.now());
		return periodo.getYears();
	}

	public boolean esDe(String ciudad) {
		return ciudadRadicacion.equalsIgnoreCase(ciudad);
	}
}
