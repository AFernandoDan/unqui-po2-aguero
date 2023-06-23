package ar.edu.unq.po2.tpStrategyYState.encriptacion;

public abstract class MetodoEncriptacion {
	protected abstract String encriptar(String textoAEncriptar);
	protected abstract String desencriptar(String textoADesencriptar);
}
