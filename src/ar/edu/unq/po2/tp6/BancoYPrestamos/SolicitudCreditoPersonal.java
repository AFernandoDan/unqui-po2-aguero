package ar.edu.unq.po2.tp6.BancoYPrestamos;

public class SolicitudCreditoPersonal extends SolicitudDeCredito {

	public SolicitudCreditoPersonal(float monto, int plazo, Solicitante solicitante) {
		super(monto, plazo, solicitante);
	}

	@Override
	public boolean esAceptable() {
		return elSueldoAnualEsMayorIgualA(15000) && laCuotaMensualNoSuperaElNPorcientoDelSueldoMensual(70);
					
	}

	private boolean elSueldoAnualEsMayorIgualA(float unaCantidadDeDinero) {
		return getSolicitante().getSueldoNetoAnual() >= unaCantidadDeDinero;
	}

}
