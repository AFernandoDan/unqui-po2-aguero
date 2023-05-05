package ar.edu.unq.po2.tp7.poquer;

public class Carta {
	private Palo palo;
	private Valor valor;
	
	public Carta(Valor valor, Palo palo) {
		setValor(valor);
		setPalo(palo);
	}
	
	private void setValor(Valor valor) {
		this.valor = valor;
	}
	
	private void setPalo(Palo palo) {
		this.palo = palo;
	}

	public Valor getValor() {
		return valor;
	}

	public Palo getPalo() {
		return palo;
	}

	public boolean tieneMismoPaloQue(Carta otraCarta) {
		return getPalo() == otraCarta.getPalo();
	}

	public boolean tieneMasValorQue(Carta otraCarta) {
		return getValor().esMayorQue(otraCarta.getValor());
	}
}
