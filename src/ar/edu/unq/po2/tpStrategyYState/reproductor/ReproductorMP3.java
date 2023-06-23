package ar.edu.unq.po2.tpStrategyYState.reproductor;

public class ReproductorMP3 {

	private StateRMP3 state;
	private Song currentSong;
	
	public ReproductorMP3(StateRMP3Seleccion estadoSeleccion) {
		setState(estadoSeleccion);
	}

	public void setState(StateRMP3 state) {
		this.state = state;
	}
	
	public StateRMP3 getState() {
		return state;
	}

	public void play(Song unaCancion) {
		getState().play(this, unaCancion);
	}

	public void setCurrentSong(Song unaCancion) {
		this.currentSong = unaCancion;
	}
	
	public Song getCurrentSong() {
		return currentSong;
	}

	public void stop() {
		getState().stop(this);
	}

	public void playWhenSelection(Song aSong, StateRMP3Reproduciendo playingState) {
		setCurrentSong(aSong);
		setState(playingState);
		aSong.play();
	}

	public void stopWhenPlaying(StateRMP3Seleccion estadoSeleccion) {
		getCurrentSong().stop();
		setCurrentSong(null);
		setState(estadoSeleccion);
	}

	public void pause() {
		state.pause(this);
	}

	public void pauseWhenPlaying(StateRMP3Pausa pauseState) {
		getCurrentSong().pause();
		setState(pauseState);
	}

	public void pauseWhenPaused(StateRMP3Reproduciendo playingState) {
		getCurrentSong().play();
		setState(playingState);
	}

}
