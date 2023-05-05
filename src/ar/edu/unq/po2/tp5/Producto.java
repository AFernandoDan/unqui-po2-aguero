package ar.edu.unq.po2.tp5;

public abstract class Producto implements Registrable {
	private String nombre;
	private float precioBase;
	private int stock;
	
	/**
	 * 
	 * @param nombre no es string vacio
	 * @param precioBase >= 0
	 * @param stock >= 0
	 */
	Producto (String nombre, float precioBase, int stock) {
		setNombre(nombre);
		setPrecioBase(precioBase);
		setStock(stock);
	}

	protected float getPrecioBase() {
		return precioBase;
	}

	/**
	 * 
	 * @param precioBase >= 0
	 */
	private void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * 
	 * @param stock >= 0
	 */
	int getStock() {
		return stock;
	}


	private void setStock(int stock) {
		this.stock = stock;
	}

	public void reducirStock() {
		setStock(getStock()-1);
	}
	
	@Override
	public float registrarseCon(Agencia agencia) {
		reducirStock();
		return getPrecio();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract float getPrecio();
}
