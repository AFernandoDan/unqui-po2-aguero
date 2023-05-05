package ar.edu.unq.po2.tpComposite.cultivos;

import java.util.ArrayList;
import java.util.List;

public class ParcelaMixta {
	
	private List<ParcelaProductiva> subParcelas;
	
	public ParcelaMixta() {
		setSubParcelas(new ArrayList<ParcelaProductiva>());
	}
	
	public void setSubParcelas(List<ParcelaProductiva> subParcelas) {
		this.subParcelas = subParcelas;
	}

	public double getProduccionAnual() {
		return getSubParcelas().stream().mapToDouble(p -> p.getProduccionAnual()).sum()/4;
	}

	public void agregarParcela(ParcelaProductiva unaParcela) {
		if (!estaLlena())
			getSubParcelas().add(unaParcela);
	}

	public boolean estaLlena() {
		return getSubParcelas().size() == getCantidadMaximaParcelas();
	}

	private int getCantidadMaximaParcelas() {
		return 4;
	}

	private List<ParcelaProductiva> getSubParcelas() {
		return subParcelas;
	}

	public void borrarParcela(ParcelaProductiva otraParcela) {
		getSubParcelas().remove(otraParcela);
	}

}
