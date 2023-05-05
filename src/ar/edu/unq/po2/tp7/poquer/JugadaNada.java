package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class JugadaNada extends Jugada {

	/**
	 * 
	 * @param cartas deben ser cinco cartas que hagan ninguna jugada
	 */
	public JugadaNada(Set<Carta> cartas) {
		super(cartas);
	}

	@Override
	public boolean leGanaA(Jugada jugada) {
		return esMismoTipoQue(jugada) && tieneCartaMasValiosaQue(jugada);
	}

	@Override
	protected TipoJugada getTipoJugada() {
		return TipoJugada.Nada;
	}

}
