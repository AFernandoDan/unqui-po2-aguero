package ar.edu.unq.po2.tpObserver.appPartidos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppPartidos {
	
	private List<Partido> partidos;
	private Map<String, HashSet<AppPartidosListener>> deportesListeners;
	private Map<String, HashSet<AppPartidosListener>> contrincantesListeners;
	
	public AppPartidos() {
		partidos = new ArrayList<Partido>();
		setDeportesListeners(new HashMap<String, HashSet<AppPartidosListener>>());
		setContrincantesListeners(new HashMap<String, HashSet<AppPartidosListener>>());
	}

	private Map<String, HashSet<AppPartidosListener>> getDeportesListeners() {
		return deportesListeners;
	}

	private void setDeportesListeners(Map<String, HashSet<AppPartidosListener>> deportesListeners) {
		this.deportesListeners = deportesListeners;
	}

	private Map<String, HashSet<AppPartidosListener>> getContrincantesListeners() {
		return contrincantesListeners;
	}

	private void setContrincantesListeners(Map<String, HashSet<AppPartidosListener>> contrincantesListeners) {
		this.contrincantesListeners = contrincantesListeners;
	}
	
	public void suscribirAContrincante(String contrincante, AppPartidosListener appPartidosListener) {
		suscribirA(getContrincantesListeners(), contrincante, appPartidosListener);
	}
	
	public void suscribirADeporte(String deporte, AppPartidosListener appPartidosListener) {
		suscribirA(getDeportesListeners(), deporte, appPartidosListener);
	}
	
	private void suscribirA(Map<String, HashSet<AppPartidosListener>> mapListeners, String clave,
			AppPartidosListener appListener) {
		if (mapListeners.containsKey(clave))
			mapListeners.get(clave).add(appListener);
		else {
			HashSet<AppPartidosListener> newSet = new HashSet<AppPartidosListener>();
			newSet.add(appListener);
			mapListeners.put(clave, newSet);
		}
	}

	public void desuscribirDeContrincante(String contrincante, AppPartidosListener appPartidosListener) {
		desuscribirDe(getContrincantesListeners(), contrincante, appPartidosListener);
	}
	
	public void desuscribirDeDeporte(String deporte, AppPartidosListener appPartidosListener) {
		desuscribirDe(getContrincantesListeners(), deporte, appPartidosListener);
	}

	private void desuscribirDe(Map<String, HashSet<AppPartidosListener>> mapListeners, String clave,
			AppPartidosListener appListener) {
		if (mapListeners.containsKey(clave)) mapListeners.get(clave).remove(appListener);
	}
	
	public void cargarPartido(Partido partido) {
		getPartidos().add(partido);
		registrarDeporteSiNoEsta(partido.getDeporte());
		registrarContrincantesSiNoEstan(partido.getContrincantes());
		notificar(partido);
	}
	
	private void registrarContrincantesSiNoEstan(List<String> contrincantes) {
		contrincantes.forEach(c -> this.registrarContrincanteSiNoEsta(c));
	}

	private void registrarContrincanteSiNoEsta(String contrincante) {
		getContrincantesListeners().putIfAbsent(contrincante, new HashSet<AppPartidosListener>());
	}

	private void registrarDeporteSiNoEsta(String deporte) {
		getDeportesListeners().putIfAbsent(deporte, new HashSet<AppPartidosListener>());
	}

	private void notificar(Partido partido) {
		getAllListeners(partido)
		.forEach(appListener -> appListener.update(partido));
		
	}

	private HashSet<AppPartidosListener> getAllListeners(Partido partido) {
		HashSet<AppPartidosListener> allListeners =
				getContrincantesListeners(partido.getContrincantes());
		allListeners.addAll(getDeportesListeners(partido.getDeporte()));
		return allListeners;
	}

	private HashSet<AppPartidosListener> getContrincantesListeners(List<String> contrincantes) {
		return (HashSet<AppPartidosListener>) contrincantes
				.stream()
				.map(c ->getContrincantesListeners()
						.getOrDefault(c, new HashSet<AppPartidosListener>()))
				.reduce((appListeners, accAppListeners) -> {
					accAppListeners.addAll(appListeners);
					return accAppListeners;
				})
				.orElse(new HashSet<AppPartidosListener>());
		
	}

	private HashSet<AppPartidosListener> getDeportesListeners(String deporte) {
		return deportesListeners.getOrDefault(deporte, new HashSet<AppPartidosListener>());
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public Set<String> getDeportes() {
		return getDeportesListeners().keySet();
	}

	public Set<String> getContrincantes() {
		return getContrincantesListeners().keySet();
	}

	public boolean tieneSuscritoEnDeporte(String deporte, AppPartidosListener unListener) {
		return estaElDeporte(deporte) && getDeportesListeners().get(deporte).equals(unListener);
	}

	public boolean estaElDeporte(String deporte) {
		return getDeportes().contains(deporte);
	}
	
	public boolean tieneSuscritoEnContrincante(String contrincante, AppPartidosListener unListener) {
		return estaElContrincante(contrincante) && getContrincantesListeners().get(contrincante).equals(unListener);
	}

	public boolean estaElContrincante(String contrincante) {
		return getContrincantes().contains(contrincante);
	}

}
