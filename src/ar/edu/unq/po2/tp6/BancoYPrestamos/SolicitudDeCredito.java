package ar.edu.unq.po2.tp6.BancoYPrestamos;

public abstract class SolicitudDeCredito {
	private float monto;
	private int plazo;
	private Solicitante solicitante;
	
	public SolicitudDeCredito(float monto, int plazo, Solicitante solicitante) {
		super();
		setMonto(monto);
		setPlazo(plazo);
		setSolicitante(solicitante);
	}
	
	public float getMonto() {
		return monto;
	}

	private void setMonto(float monto) {
		this.monto = monto;
	}
	
	public int getPlazo() {
		return plazo;
	}
	
	private void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
	public Solicitante getSolicitante() {
		return solicitante;
	}
	
	private void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	
	public abstract boolean esAceptable();

	public float getMontoMensual() {
		return getMonto() / getPlazo();
	}
	
	public boolean laCuotaMensualNoSuperaElNPorcientoDelSueldoMensual(float porcentajeDelSueldo) {
		return getMontoMensual() <= getSolicitante().getSueldoNetoMensual()*porcentajeDelSueldo/100;
	}
	
}
