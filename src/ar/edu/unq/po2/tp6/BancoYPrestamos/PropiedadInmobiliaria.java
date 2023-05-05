package ar.edu.unq.po2.tp6.BancoYPrestamos;

public class PropiedadInmobiliaria {
	
	private String descripcion, direccion;
	private float valorFiscal;

	public PropiedadInmobiliaria(String descripcion, String direccion, float valorFiscal) {
		setDescripcion(descripcion);
		setDireccion(direccion);
		setValorFiscal(valorFiscal);
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getValorFiscal() {
		return valorFiscal;
	}

	private void setValorFiscal(float valorFiscal) {
		this.valorFiscal = valorFiscal;
	}

	
}
