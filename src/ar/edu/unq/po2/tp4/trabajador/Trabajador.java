package ar.edu.unq.po2.tp4.trabajador;

import java.util.List;

public class Trabajador {
	
	private List<IngresoGenerico> ingresos;

	public void agregarIngreso(IngresoGenerico ingreso) {
		ingresos.add(ingreso);
	}
	
	public double getTotalPercibido() {
		return ingresos.stream()
				.mapToDouble(ingreso -> ingreso.getMonto())
			    .reduce(0, (a, b) -> a + b);
	}
	
	public double getMontoImponible() {
		return ingresos.stream()
				.mapToDouble(ingreso -> ingreso.getMontoImponible())
			    .reduce(0, (a, b) -> a + b);
	}

	public double getImpuestoAPagar() {
		return getMontoImponible() / 100 * 2;
	}
}
