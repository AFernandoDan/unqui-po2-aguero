package ar.edu.unq.po2.tpObserver.appPartidos;

public class AppMovil extends AppPartidosListener {

	public AppMovil(AppPartidos appPartidos) {
		super(appPartidos);
	}

	@Override
	public void update(Partido partido) {
		
	}
	
	public void suscribirseAContrincante(String deporte) {
		getAppPartidos().suscribirAContrincante(deporte, this);
	}
	
	public void desuscribirseDeContrincante(String deporte) {
		getAppPartidos().desuscribirDeContrincante(deporte, this);
	}

}
