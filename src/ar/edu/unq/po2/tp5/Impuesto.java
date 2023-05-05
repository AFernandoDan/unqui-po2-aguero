package ar.edu.unq.po2.tp5;

public class Impuesto extends Factura {

	private float tasaDelServicio;
	
	/**
	 * 
	 * @param tasaDelServicio >= 0
	 */
	public Impuesto (String nombre, float tasaDelServicio) {
		super(nombre);
		setTasaDelServicio(tasaDelServicio);
	}
	
	public float getTasaDelServicio() {
		return tasaDelServicio;
	}

	private void setTasaDelServicio(float tasaDelServicio) {
		this.tasaDelServicio = tasaDelServicio;
	}

	@Override
	public float getMontoAPagar() {
		return getTasaDelServicio();
	}

}
