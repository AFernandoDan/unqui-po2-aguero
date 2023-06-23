package ar.edu.unq.po2.tpObserver.appPartidos;

public abstract class AppPartidosListener {

	private AppPartidos appPartidos;
	
	public AppPartidosListener(AppPartidos appPartidos) {
		setAppPartidos(appPartidos);
	}
	
	private void setAppPartidos(AppPartidos appPartidos) {
		this.appPartidos = appPartidos;
	}
	
	public AppPartidos getAppPartidos() {
		return appPartidos;
	}
	
	public abstract void update(Partido partido);
	
	public void suscribirseADeporte(String deporte) {
		getAppPartidos().suscribirADeporte(deporte, this);
	}
	
	public void desuscribirseDeDeporte(String deporte) {
		getAppPartidos().desuscribirDeDeporte(deporte, null);
	}
	
}
