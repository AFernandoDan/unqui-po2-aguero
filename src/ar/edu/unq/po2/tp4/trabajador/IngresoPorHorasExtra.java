package ar.edu.unq.po2.tp4.trabajador;

public class IngresoPorHorasExtra extends IngresoGenerico {
	private int horasExtra;
	
	public IngresoPorHorasExtra(String mesDePercepcion, String concepto, double monto, int horasExtra) {
		super(mesDePercepcion, concepto, monto);
		setHorasExtra(horasExtra);
	}
	
	private void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}

	@Override
	public double getMontoImponible() {
		return 0;
	}
}
