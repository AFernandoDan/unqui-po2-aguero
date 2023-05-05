package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public abstract class EstadoDeCartasMismoValor implements EstadoDeCartas {
	protected boolean hayNCartasDelMismoValor(int cantidad, Set<Carta> cartas) {
		return cartas
				.stream()
				.anyMatch(c -> this.hayNCartasDeValor(c.getValor(), cantidad, cartas));
	}

	private boolean hayNCartasDeValor(Valor valorC, int cantidad, Set<Carta> cartas) {
		return cartas
				.stream()
				.filter(c -> c.getValor().equals(valorC))
				.count() == cantidad;
	}
}
