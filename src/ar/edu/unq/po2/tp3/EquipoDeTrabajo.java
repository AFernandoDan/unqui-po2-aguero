package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class EquipoDeTrabajo {
	private String nombre;
	private ArrayList<Persona> integrantes;
	
	public EquipoDeTrabajo(String nombre) {
		super();
		setIntegrantes(new ArrayList<Persona>());
		setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private ArrayList<Persona> getIntegrantes() {
		return integrantes;
	}
	
	private void setIntegrantes(ArrayList<Persona> integrantes) {
		this.integrantes = integrantes;
	}
	
	public void addIntegrante(Persona integrante) {
		integrantes.add(integrante);
	}
	
	public int promedioEdadIntegrantes() {
		return new MultiOperador().sumar(edadesIntegrantes()) / cantidadIntegrantes();
	}
	
	private Integer cantidadIntegrantes() {
		return integrantes.size();
	}

	private ArrayList<Integer> edadesIntegrantes() {
		ArrayList<Integer> edades = new ArrayList<Integer>();
		for (Persona integrante:integrantes) {
			edades.add(integrante.getEdad());
		}
		return edades;
	}
	
}
