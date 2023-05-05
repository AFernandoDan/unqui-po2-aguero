package ar.edu.unq.po2.tp7.poquer;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PokerStatus {

	public Jugada verificar(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
		Set<Carta> cartas = Set.of(c1, c2, c3, c4, c5);
		return getJugadaPara(cartas);
	}
	
	private Jugada getJugadaPara(Set<Carta> cartas) {
		List<EstadoDeCartas> estados = Arrays.asList(
				new EstadoDeCartasColor(),
				new EstadoDeCartasPoker(),
				new EstadoDeCartasTrio(),
				new EstadoDeCartasNada());

		return estados
				.stream()
				.filter(estado -> estado.esAdecuadoPara(cartas))
				.findFirst()
				.orElse(null)
				.getJugadaPara(cartas);
	}

}
