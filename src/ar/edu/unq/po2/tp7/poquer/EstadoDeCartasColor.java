package ar.edu.unq.po2.tp7.poquer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EstadoDeCartasColor implements EstadoDeCartas {

	@Override
	public boolean esAdecuadoPara(Set<Carta> cartas) {
		return hayNCartasYSonTodasDelMismoPalo(cartas);
	}
	
	private boolean hayNCartasYSonTodasDelMismoPalo(Set<Carta> cartas) {
		return getCantidadPalos(cartas) == 1 && cartas.size() == 5;
	}

	private int getCantidadPalos(Set<Carta> cartas) {
		return getPalos(cartas).size();
	}

	private HashSet<Palo> getPalos(Set<Carta> cartas) {
		return new HashSet<Palo>(getPalosConRepetidos(cartas));
	}

	private List<Palo> getPalosConRepetidos(Set<Carta> cartas) {
		return cartas.stream().map(c -> c.getPalo()).toList();
	}

	@Override
	public JugadaColor getJugadaPara(Set<Carta> cartas) {
		return new JugadaColor(cartas);
	}

}
