package ar.edu.unq.po2.tpStrategyYState.encriptacion;

public class MetodoOrden extends MetodoEncriptacion {

	@Override
	public String encriptar(String textoAEncriptar) {
		return cambiarOrdenPalabrasPrimeroPorSiguiente(textoAEncriptar);
	}

	private String cambiarOrdenPalabrasPrimeroPorSiguiente(String textoAEncriptar) {
		String[] palabras = getPalabras(textoAEncriptar);
	    for (int i = 0; i < palabras.length - 1; i += 2) {
	        String temp = palabras[i];
	        palabras[i] = palabras[i + 1];
	        palabras[i + 1] = temp;
	    }
	    return String.join(" ", palabras);
	}

	

	private String[] getPalabras(String texto) {
		return texto.split("\\s+");
	}

	@Override
	protected String desencriptar(String textoADesencriptar) {
		return cambiarOrdenPalabrasPrimeroPorSiguiente(textoADesencriptar);
	}

}
