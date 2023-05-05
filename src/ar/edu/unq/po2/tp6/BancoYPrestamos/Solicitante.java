package ar.edu.unq.po2.tp6.BancoYPrestamos;

public class Solicitante {
	private String nombre, apellido, direccion;
	private int edad;
	private float sueldoNetoMensual;

	public Solicitante(String nombre, String apellido, String direccion, int edad, float sueldoNetoMensual) {
		setNombre(nombre);
		setApellido(apellido);
		setDireccion(direccion);
		setEdad(edad);
		setSueldoNetoMensual(sueldoNetoMensual);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}

	public void setSueldoNetoMensual(float sueldoNetoMensual) {
		this.sueldoNetoMensual = sueldoNetoMensual;
	}

	public float getSueldoNetoAnual() {
		return getSueldoNetoMensual() * 12;
	}

	public boolean esMenorDeAlPasarNMeses(int unaEdad, int plazoEnMeses) {
		return getEdad() + plazoEnMeses/12 < unaEdad;
	}

}
