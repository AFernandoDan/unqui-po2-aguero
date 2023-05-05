package ar.edu.unq.po2.tpStreamsYEnums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Municipio {

	private List<ActividadSemanal> actividades;

	public Municipio() {
		setActividades(new ArrayList<ActividadSemanal>());
	}
	
	private void setActividades(List<ActividadSemanal> actividades) {
		this.actividades = actividades;
	}
	
	public List<ActividadSemanal> getActividades() {
		return actividades;
	}

	public List<ActividadSemanal> getActividadesFutbol() {
		return getActividades()
				.stream().filter(a -> a.esDe(Deporte.FUTBOL))
				.toList();
	}

	public void agregarActividad(ActividadSemanal actividad) {
		getActividades().add(actividad);
	}

	public Integer getHorasSemanalesDeActividades() {
		return getActividades()
				.stream()
				.mapToInt(a -> a.getDuracion())
				.sum();
	}

	public ActividadSemanal getActividadMasBarataDe(Deporte deporte) {
		return getActividades()
				.stream()
				.filter(a -> a.esDe(deporte))
				.sorted(Comparator.comparing(ActividadSemanal::getCosto))
				.findFirst()
				.orElse(null);
	}

	public Map<Deporte, ActividadSemanal> getActividadesMasBaratas() {
		return getActividades()
			.stream()
			.collect(Collectors.groupingBy(
					ActividadSemanal::getDeporte,
					Collectors.minBy(Comparator.comparing(ActividadSemanal::getCosto))))
			.entrySet()
			.stream()
			.collect(Collectors.toMap(Map.Entry::getKey,e -> e.getValue().orElse(null)));
	}

	public String imprimirActividades() {
		return getActividades()
				.stream()
				.map(a -> "Actividad: " + a.toString())
				.collect(Collectors.joining("\n"));
	}

}
