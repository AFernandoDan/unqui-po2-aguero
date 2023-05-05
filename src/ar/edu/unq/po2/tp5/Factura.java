package ar.edu.unq.po2.tp5;

public abstract class Factura implements Registrable {
	
	private String nombre;
	
	Factura(String nombre) {
		setNombre(nombre);
	}

	public abstract float getMontoAPagar();
	
	@Override
	public float registrarseCon(Agencia agencia) {
		agencia.registrarPago(this);
		return getMontoAPagar();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
