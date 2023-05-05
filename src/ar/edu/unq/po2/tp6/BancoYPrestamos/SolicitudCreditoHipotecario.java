package ar.edu.unq.po2.tp6.BancoYPrestamos;

public class SolicitudCreditoHipotecario extends SolicitudDeCredito {

	private PropiedadInmobiliaria propiedadGarantia;

	public SolicitudCreditoHipotecario(float monto, int plazo, Solicitante solicitante, PropiedadInmobiliaria propiedadInmobiliaria) {
		super(monto, plazo, solicitante);
		setPropiedadGarantia(propiedadInmobiliaria);
	}
	
	public PropiedadInmobiliaria getPropiedadGarantia() {
		return propiedadGarantia;
	}

	private void setPropiedadGarantia(PropiedadInmobiliaria propiedadGarantia) {
		this.propiedadGarantia = propiedadGarantia;
	}

	@Override
	public boolean esAceptable() {
		return getSolicitante().esMenorDeAlPasarNMeses(65, getPlazo()) &&
				laCuotaMensualNoSuperaElNPorcientoDelSueldoMensual(50) &&
				elMontoSolicitadoNoSuperaEL70PorcientoDelValorDeLaGarantia();
	}

	private boolean elMontoSolicitadoNoSuperaEL70PorcientoDelValorDeLaGarantia() {
		return getMonto() <= getPropiedadGarantia().getValorFiscal() * 0.70; 
	}

}
