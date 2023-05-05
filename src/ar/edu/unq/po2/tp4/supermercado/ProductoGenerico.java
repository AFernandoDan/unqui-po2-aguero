package ar.edu.unq.po2.tp4.supermercado;

public abstract class ProductoGenerico {
	private String nombre;
	private Double precioBase;
	private Boolean esPrecioCuidado;
	
	public ProductoGenerico(String nombre, Double precioBase, Boolean esPecioCuidado) {
		super();
		setNombre(nombre);
		setPrecioBase(precioBase);
		setEsPecioCuidado(esPecioCuidado);
	}
	
	public ProductoGenerico(String nombre, Double precioBase) {
		super();
		setNombre(nombre);
		setPrecioBase(precioBase);
		setEsPecioCuidado(false);
	}

	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected Double getPrecioBase() {
		return precioBase;
	}
	
	private void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	
	private Boolean getEsPecioCuidado() {
		return esPrecioCuidado;
	}
	
	public Boolean esPrecioCuidado() {
		return getEsPecioCuidado();
	}
	
	private void setEsPecioCuidado(Boolean esPecioCuidado) {
		this.esPrecioCuidado = esPecioCuidado;
	}
	
	public abstract Double getPrecio();
	
	public void aumentarPrecio(Double aumentoDePrecio) {
		setPrecioBase(getPrecioBase() + aumentoDePrecio);
	}
}
