package ar.edu.unq.po2.tp7.poquer;

public enum TipoJugada {
	Nada, Trio, Color, Poker;

	public boolean leGanaA(TipoJugada otroTipoJugada) {
		return ordinal() > otroTipoJugada.ordinal();
	}
}
