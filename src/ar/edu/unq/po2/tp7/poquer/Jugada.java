package ar.edu.unq.po2.tp7.poquer;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public abstract class Jugada {
	
	private Set<Carta> cartas;
	
	public Jugada(Set<Carta> cartas) {
		setCartas(cartas);
	}
	
	private void setCartas(Set<Carta> cartas) {
		this.cartas = cartas;
	}

	abstract public boolean leGanaA(Jugada jugada);
	
	protected Set<Carta> getCartas() {
		return cartas;
	}

	protected abstract TipoJugada getTipoJugada();
	
	protected boolean tipoLeGanaATipoDe(Jugada jugada) {
		return getTipoJugada().leGanaA(jugada.getTipoJugada());
	}

	protected boolean esMismoTipoQue(Jugada jugada) {
		return getTipoJugada() == jugada.getTipoJugada();
	}

	protected Valor valorCartaQueApareceNVeces(int apariciones) {
		List<Valor> valores = getValoresCartas();
		return valores
				.stream()
				.filter(v -> valores
								.stream()
								.filter(val -> val.equals(v))
								.count() == apariciones)
				.findFirst().orElse(null);
	}

	private List<Valor> getValoresCartas() {
		return getCartas().stream().map(c -> c.getValor()).toList();
	}

	protected boolean tieneCartaMasValiosaQue(Jugada jugada) {
		return getCartaMasValiosa().tieneMasValorQue(jugada.getCartaMasValiosa());
	}

	public Carta getCartaMasValiosa() {
		return getCartas().stream().max(Comparator.comparing(Carta::getValor)).orElse(null);
	}
}
