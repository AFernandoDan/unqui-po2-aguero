package ar.edu.unq.po2.tp4.trabajador;

public class Ingreso extends IngresoGenerico {
	public Ingreso(String mesDePercepcion, String concepto, double monto) {
		super(mesDePercepcion, concepto, monto);
	}

	@Override
	public double getMontoImponible() {
		return getMonto();
	}
	
}
