package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class JugadaPoker extends Jugada {
	/**
	 * 
	 * @param cartas debe ser una lista de 5 cartas que hagan poker.
	 */
	public JugadaPoker(Set<Carta> cartas) {
		super(cartas);
	}

	@Override
	public boolean leGanaA(Jugada jugada) {
		return tipoLeGanaATipoDe(jugada) || esMejorPokerQue((JugadaPoker) jugada);  
	}

	private boolean esMejorPokerQue(JugadaPoker jugada) {
		return getValorPoker().esMayorQue(jugada.getValorPoker());
	}
	
	private Valor getValorPoker() {
		return valorCartaQueApareceNVeces(4);
	}

	@Override
	protected TipoJugada getTipoJugada() {
		return TipoJugada.Poker;
	}

}
