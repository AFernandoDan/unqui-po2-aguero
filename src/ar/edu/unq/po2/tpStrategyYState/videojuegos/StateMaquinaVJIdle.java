package ar.edu.unq.po2.tpStrategyYState.videojuegos;

public class StateMaquinaVJIdle extends StateMaquinaVJ {
	@Override
	public void ingresarFicha(MaquinaVJ maquina) {
		maquina.setState(new StateMaquinaVJFichaIngresada());
	}
}
