package ar.edu.unq.po2.tpStrategyYState.encriptacion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MetodoVocal extends MetodoEncriptacion{
	
	private HashMap<String, String> vocalesSiguientes = new HashMap<>();
	private HashMap<String, String> vocalesAnteriores = new HashMap<>();
	
	public MetodoVocal() {
		vocalesSiguientes.put("a", "e");
		vocalesSiguientes.put("e", "i");
		vocalesSiguientes.put("i", "o");
		vocalesSiguientes.put("o", "u");
		vocalesSiguientes.put("u", "a");
		
		vocalesAnteriores.put("a", "u");
		vocalesAnteriores.put("e", "a");
		vocalesAnteriores.put("i", "e");
		vocalesAnteriores.put("o", "i");
		vocalesAnteriores.put("u", "o");
	}

	public String encriptar(String textoAEncriptar) {
		return cambiarVocalesPorSiguientes(textoAEncriptar.split(""));
	}

	private String cambiarVocalesPorSiguientes(String[] caracteres) {
		return Arrays
				.stream(caracteres)
				.map(c -> this.getSiguienteVocal(c))
				.collect(Collectors.joining())
				.toString();
	}
	
	private String cambiarVocalesPorAnteriores(String[] caracteres) {
		return Arrays
				.stream(caracteres)
				.map(c -> this.getAnteriorVocal(c))
				.collect(Collectors.joining())
				.toString();
	}

	private String getAnteriorVocal(String c) {
		return vocalesAnteriores.getOrDefault(c, c);
	}

	private String getSiguienteVocal(String c) {
		return vocalesSiguientes.getOrDefault(c, c);
	}

	@Override
	protected String desencriptar(String textoADesencriptar) {
		return cambiarVocalesPorAnteriores(textoADesencriptar.split(""));
	}
	
}
