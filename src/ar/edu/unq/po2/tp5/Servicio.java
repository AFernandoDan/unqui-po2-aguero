package ar.edu.unq.po2.tp5;

public class Servicio extends Factura {
	private float costoPorUnidad;
	private int unidadesConsumidas;
	
	/**
	 * 
	 * @param costoPorUnidad >= 0
	 * @param unidadesConsumidas >= 0
	 */
	public Servicio(String nombre, float costoPorUnidad, int unidadesConsumidas) {
		super(nombre);
		setCostoPorUnidad(costoPorUnidad);
		setUnidadesConsumidas(unidadesConsumidas);
	}

	public float getCostoPorUnidad() {
		return costoPorUnidad;
	}

	private void setCostoPorUnidad(float costoPorUnidad) {
		this.costoPorUnidad = costoPorUnidad;
	}

	public int getUnidadesConsumidas() {
		return unidadesConsumidas;
	}

	private void setUnidadesConsumidas(int unidadesConsumidas) {
		this.unidadesConsumidas = unidadesConsumidas;
	}

	@Override
	public float getMontoAPagar() {
		return getCostoPorUnidad() * getUnidadesConsumidas();
	}
	
}
