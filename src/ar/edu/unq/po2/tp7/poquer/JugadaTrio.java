package ar.edu.unq.po2.tp7.poquer;

import java.util.Set;

public class JugadaTrio extends Jugada {

	/**
	 * 
	 * @param cartas deben ser cinco cartas y que 3 de ellas tengan mismo valor
	 */
	public JugadaTrio(Set<Carta> cartas) {
		super(cartas);
	}

	@Override
	public boolean leGanaA(Jugada jugada) {
		return tipoLeGanaATipoDe(jugada) || esMismoTipoYValeMasQue(jugada);
	}

	private boolean esMismoTipoYValeMasQue(Jugada jugada) {
		return esMismoTipoQue(jugada) && esMejorTrioQue((JugadaTrio) jugada);
	}

	private boolean esMejorTrioQue(JugadaTrio jugada) {
		return getValorTrio().esMayorQue(jugada.getValorTrio());
	}

	private Valor getValorTrio() {
		return valorCartaQueApareceNVeces(3);
	}

	@Override
	protected TipoJugada getTipoJugada() {
		// TODO Auto-generated method stub
		return TipoJugada.Trio;
	}

}
