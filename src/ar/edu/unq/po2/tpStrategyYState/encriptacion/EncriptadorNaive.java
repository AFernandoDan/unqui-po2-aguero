package ar.edu.unq.po2.tpStrategyYState.encriptacion;

public class EncriptadorNaive {

	private MetodoEncriptacion metodoEncriptacion;
	
	public EncriptadorNaive(MetodoEncriptacion metodoEncriptacion) {
		setMetodoEncriptacion(metodoEncriptacion);
	}

	public String encriptar(String textoAEncriptar) {
		return metodoEncriptacion.encriptar(textoAEncriptar);
	}
	
	private void setMetodoEncriptacion(MetodoEncriptacion metodoEncriptacion) {
		this.metodoEncriptacion = metodoEncriptacion;
	}

	public String desencriptar(String textoADesencriptar) {
		return metodoEncriptacion.desencriptar(textoADesencriptar);
	}

}
