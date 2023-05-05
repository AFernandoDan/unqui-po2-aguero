package ar.edu.unq.po2.tp4.supermercado;

public class ProductoPrimeraNecesidad extends ProductoGenerico {
	
	private int porcentajeDeDescuento;

	public ProductoPrimeraNecesidad(String nombre, Double precioBase, Boolean esPrecioCuidado, int porcentajeDeDescuento) {
		super(nombre, precioBase, esPrecioCuidado);
		setPorcentajeDeDescuento(porcentajeDeDescuento);
	}

	public ProductoPrimeraNecesidad(String nombre, double precioBase, int porcentajeDeDescuento) {
		super(nombre, precioBase);
		setPorcentajeDeDescuento(porcentajeDeDescuento);
	}

	private void setPorcentajeDeDescuento(int porcentajeDeDescuento) {
		this.porcentajeDeDescuento = porcentajeDeDescuento;
	}
	
	private int getPorcentajeDeDescuento() {
		return porcentajeDeDescuento;
	}

	@Override
	public Double getPrecio() {
		return getPrecioBase() - getPrecioBase() * getFactorDeDescuento();
	}

	private Double getFactorDeDescuento() {
		return getPorcentajeDeDescuento() / 100d;
	}
}
