package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class EstadoDeCartasNada implements EstadoDeCartas {

	@Override
	public boolean esAdecuadoPara(Set<Carta> cartas) {
		return true;
	}

	@Override
	public JugadaNada getJugadaPara(Set<Carta> cartas) {
		return new JugadaNada(cartas);
	}

}
