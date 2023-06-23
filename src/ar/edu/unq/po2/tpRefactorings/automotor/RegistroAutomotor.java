package ar.edu.unq.po2.tpRefactorings.automotor;

import java.time.LocalDate;

public class RegistroAutomotor {

	public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) {
		
		// vehiculos policiales no realizan vtv, ya que tienen otro tipo de control
		// sólo realizan vtv los vehículos con más de 1 anio de antiguedad y radicados
		// en 'Buenos Aires'
		return
				!vehiculo.esVehiculoPolicial() &&
				tieneMasDeNAnios(vehiculo, 1) &&
				vehiculo.esDe("Buenos Aires");

	}

	private boolean tieneMasDeNAnios(Vehiculo vehiculo, int anios) {
		return vehiculo.aniosDeAnitiguedad() > anios;
	}
}
