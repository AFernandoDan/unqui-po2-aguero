package ar.edu.unq.po2.tpStrategyYState.reproductor;

public abstract class StateRMP3 {

	public void play(ReproductorMP3 rmp3, Song aSong) {
		throw new Error("No se pudo reproducir la canción");
	}

	protected void stop(ReproductorMP3 reproductorMP3) {
		
	}
	
	public void pause(ReproductorMP3 reproductorMP3Test) {

	}

}
