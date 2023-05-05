package ar.edu.unq.po2.tpStreamsYEnums;

public class ActividadSemanal {

	private DiaDeLaSemana dia;
	private int horaInicio;
	private int duracion;
	private Deporte deporte;

	/**
	 * 
	 * @param dia es el dia de la semana en que se lleva a cabo la actividad
	 * @param horaInicio un entero del 0 al 23
	 * @param duracion numero entero que indica la cantidad de horas que dura
	 * @param deporte deporte que se realiza durante la actividad
	 */
	public ActividadSemanal(DiaDeLaSemana dia, int horaInicio, int duracion, Deporte deporte) {
		setDia(dia);
		setHoraInicio(horaInicio);
		setDuracion(duracion);
		setDeporte(deporte);
	}

	public DiaDeLaSemana getDia() {
		return dia;
	}

	private void setDia(DiaDeLaSemana dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	private void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	private void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	private void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Integer getCosto() {
		return getCostoPorDiaDeLaSemana() + getCostoComplejidad();
	}

	private int getCostoComplejidad() {
		return getFactorCostoComplejidad() * getDeporte().getComplejidad();
	}

	private int getFactorCostoComplejidad() {
		return 200;
	}

	private int getCostoPorDiaDeLaSemana() {
		if (getDia() == DiaDeLaSemana.LUNES ||
				getDia() == DiaDeLaSemana.MARTES ||
				getDia() == DiaDeLaSemana.MIERCOLES)
			return 500;
		else {
			return 1000;
		}
	}

	public boolean esDe(Deporte deporte) {
		return getDeporte() == deporte;
	}

	@Override
	public String toString() {
		return "Deporte: " +
				getDeporte() +
				". Dia: " + getDia() +
				" A LAS: " +
				getHoraInicio() +
				". Duración: " +
				getDuracion() +
				" hora(s).";
	}
}
