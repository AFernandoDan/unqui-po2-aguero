package ar.edu.unq.po2.tp6.BancoYPrestamos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class Banco {
	private List<SolicitudDeCredito> solicitudesDeCredito;
	
	public Banco() {
		setSolicitudesDeCredito(new ArrayList<SolicitudDeCredito>());
	}

	private void setSolicitudesDeCredito(ArrayList<SolicitudDeCredito> solicitudesDeCredito) {
		this.solicitudesDeCredito = solicitudesDeCredito;
	}

	public List<SolicitudDeCredito> getSolicitudesDeCredito() {
		return solicitudesDeCredito;
	}

	public void registrarSolicitudDeCredito(SolicitudDeCredito solicitud) {
		getSolicitudesDeCredito().add(solicitud);
	}

	public boolean tieneSolicitudesDeCredito() {
		return !getSolicitudesDeCredito().isEmpty();
	}

	public boolean tieneLaSolicitud(SolicitudDeCredito solicitud) {
		return getSolicitudesDeCredito().contains(solicitud);
	}

	public float montoADesembolsar() {
		return getSolicitudesAceptables().stream().map(s -> s.getMonto()).reduce(0f, Float::sum);
	}

	public Integer cantSolicitudesAceptables() {
		return getSolicitudesAceptables().size();
	}

	private List<SolicitudDeCredito> getSolicitudesAceptables() {
		return getSolicitudesDeCredito()
				.stream()
				.filter(s -> s.esAceptable())
				.toList();
	}

}
