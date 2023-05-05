package ar.edu.unq.po2.tpStreamsYEnums;

public enum ColorLesion {
    ROJO("Lesión inflamada o irritada", 4) {
		@Override
		public ColorLesion getSiguiente() {
			return GRIS;
		}
	},
    
    GRIS("Lesión curada o en proceso de curación", 1) {
		@Override
		public ColorLesion getSiguiente() {
			return AMARILLO;
		}
	},
    
    AMARILLO("Lesión con pus o infección", 3) {
		@Override
		public ColorLesion getSiguiente() {
			return MIEL;
		}
	},
    
	MIEL("Lesión con costra o cicatrización", 2) {
		@Override
		public ColorLesion getSiguiente() {
			return ROJO;
		}
	};

	private String descripcion;
	private int nivelDeRiesgo;

	ColorLesion(String descripcion, int nivelDeRiesgo) {
		setDescripcion(descripcion);
		setNivelDeRiesgo(nivelDeRiesgo);
	}
	
	public void setNivelDeRiesgo(int nivelDeRiesgo) {
		this.nivelDeRiesgo = nivelDeRiesgo;
	}
	
	public int getNivelDeRiesgo() {
		return nivelDeRiesgo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public abstract ColorLesion getSiguiente();

}
