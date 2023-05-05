package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class MultiOperador {
	MultiOperador() {
		
	}
	
	public Integer sumar(ArrayList<Integer> enteros) {
		Integer resultado = 0;
		for (Integer entero:enteros)
			resultado += entero;
		return resultado;
	}
	
	public Integer restar(ArrayList<Integer> enteros) {
		Integer resultado = 0;
		for (Integer entero:enteros)
			resultado -= entero;
		return resultado;
	}
	
	public Integer multiplicar(ArrayList<Integer> enteros) {
		Integer resultado = 1;
		for (Integer entero:enteros)
			resultado *= entero;
		return resultado;
	}
}
