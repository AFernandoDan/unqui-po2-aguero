package ar.edu.unq.po2.tp4.trabajador;

public abstract class IngresoGenerico {
	private String mesDePercepcion;
	private String concepto;
	private double monto;
	
	public IngresoGenerico(String mesDePercepcion, String concepto, double monto) {
		super();
		setMesDePercepcion(mesDePercepcion);
		setConcepto(concepto);
		setMonto(monto);
	}
	
	private void setMesDePercepcion(String mesDePercepcion) {
		this.mesDePercepcion = mesDePercepcion;
	}
	
	private void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	protected double getMonto() {
		return monto;
	}
	
	private void setMonto(double monto) {
		this.monto = monto;
	}
	
	public abstract double getMontoImponible();
	
}
