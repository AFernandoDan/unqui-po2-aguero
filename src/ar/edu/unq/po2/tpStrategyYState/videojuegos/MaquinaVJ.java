package ar.edu.unq.po2.tpStrategyYState.videojuegos;

public class MaquinaVJ {

	private StateMaquinaVJ state;
	
	public MaquinaVJ(StateMaquinaVJIdle estadoInicial) {
		setState(estadoInicial);
	}
	
	public void setState(StateMaquinaVJ state) {
		this.state = state;
	}
	
	public StateMaquinaVJ getState() {
		return state;
	}

	public void ingresarFicha() {
		state.ingresarFicha(this);
	}

	public void presionarBoton() {
		state.presionarBoton(this);
	}

}
