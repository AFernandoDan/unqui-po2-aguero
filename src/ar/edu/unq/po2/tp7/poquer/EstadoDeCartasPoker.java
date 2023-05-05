package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class EstadoDeCartasPoker extends EstadoDeCartasMismoValor implements EstadoDeCartas {

	@Override
	public boolean esAdecuadoPara(Set<Carta> cartas) {
		return hayNCartasDelMismoValor(4,cartas);
	}

	@Override
	public JugadaPoker getJugadaPara(Set<Carta> cartas) {
		return new JugadaPoker(cartas);
	}

}
