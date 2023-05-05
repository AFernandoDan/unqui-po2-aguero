package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class EstadoDeCartasTrio extends EstadoDeCartasMismoValor implements EstadoDeCartas {
	@Override
	public boolean esAdecuadoPara(Set<Carta> cartas) {
		return hayNCartasDelMismoValor(3,cartas);
	}

	@Override
	public JugadaTrio getJugadaPara(Set<Carta> cartas) {
		return new JugadaTrio(cartas);
	}

}
