package ar.edu.unq.po2.tpObserver.appPartidos;

import java.util.List;

public class Partido {
	private String deporte;
	private List<String> contrincantes;
	private String resultado;
	
	public Partido(String deporte, List<String> contrincantes, String resultado) {
		setDeporte(deporte);
		setContrincantes(contrincantes);
		setResultado(resultado);
	}
	
	public String getDeporte() {
		return deporte;
	}
	
	private void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	public List<String> getContrincantes() {
		return contrincantes;
	}
	
	private void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;
	}
	
	public String getResultado() {
		return resultado;
	}
	
	private void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
