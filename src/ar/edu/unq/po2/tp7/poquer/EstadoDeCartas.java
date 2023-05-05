package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public interface EstadoDeCartas {

	public boolean esAdecuadoPara(Set<Carta> cartas);

	public Jugada getJugadaPara(Set<Carta> cartas);
}
