package ar.edu.unq.po2.tp7.poquer;

public enum Valor {
	DOS,
	TRES,
	CUATRO,
	CINCO,
	SEIS,
	SIETE,
	OCHO,
	NUEVE,
	DIEZ,
	J,
	Q,
	K,
	AS;

	public boolean esMayorQue(Valor valor) {
		return ordinal() > valor.ordinal();
	}
}
