package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class JugadaColor extends Jugada {

	/**
	 * 
	 * @param cartas deben ser cinco cartas que tengan todas el mismo palo
	 */
	public JugadaColor(Set<Carta> cartas) {
		super(cartas);
	}

	@Override
	public boolean leGanaA(Jugada jugada) {
		return tipoLeGanaATipoDe(jugada) || esMismoTipoYValeMasQue(jugada);
	}

	protected boolean esMismoTipoYValeMasQue(Jugada jugada) {
		return esMismoTipoQue(jugada) && tieneCartaMasValiosaQue(jugada);
	}

	@Override
	protected TipoJugada getTipoJugada() {
		return TipoJugada.Color;
	}

}
