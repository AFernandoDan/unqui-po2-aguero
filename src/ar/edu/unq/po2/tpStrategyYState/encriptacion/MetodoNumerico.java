package ar.edu.unq.po2.tpStrategyYState.encriptacion;


import java.util.Arrays;
import java.util.stream.Collectors;

public class MetodoNumerico extends MetodoEncriptacion {
	
	public MetodoNumerico() {
	}

	@Override
	/**
	 * @param textoAEncriptar es un texto que solo tiene minusculas y espacios.
	 */
	protected String encriptar(String textoAEncriptar) {
		return textoAEncriptar
				.chars()
				.mapToObj(c -> String.valueOf(c - 96))
				.collect(Collectors.joining(", "))
				.replaceAll("-64", "0");
	}

	@Override
	protected String desencriptar(String textoADesencriptar) {
		return Arrays
				.stream(
					textoADesencriptar
						.replace(" 0,", " -64,")
						.split(", "))
				.map(s -> String.valueOf((char) (Integer.parseInt(s)+96)))
				.collect(Collectors.joining());
	}

}
