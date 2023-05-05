package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {
	ArrayList<Integer> numeros = new ArrayList<Integer>();
	
	public int cantidadDePares() {
		return multiplosDe(2).size();
	}
	
	public int cantidadDeImpares() {
		return numeros.stream().filter(n -> !esMultiploDe(n,2)).collect(Collectors.toList()).size();
	}
	
	public void addNumber(Integer n) {
		numeros.add(n);
	}

	public int cantidadDeMultiplosDe(int i) {
		return multiplosDe(i).size();
	}
	
	private List<Integer> multiplosDe(int i) {
		return numeros.stream().filter(n -> esMultiploDe(n,i)).collect(Collectors.toList());
	}
	
	private static Boolean esMultiploDe(Integer n, int i) {
		return n % i == 0;
	}

	public static int numeroConMayorCantidadDeDigitosPares(int[] enteros) {
		int numeroConMasDigitosPares = enteros[0];
		for (int entero: enteros) {
			numeroConMasDigitosPares =
					numeroConMasDigitosParesEntreDosNumeros(numeroConMasDigitosPares, entero);
		}
		return numeroConMasDigitosPares;
	}
	
	private static int numeroConMasDigitosParesEntreDosNumeros(int n, int m) {
		if (tieneMasDigitosParesQue(n,m))
			return n;
		else
			return m;
	}
	
	private static boolean tieneMasDigitosParesQue(int n, int m) {
		return cantidadDeDigitosPares(n) > cantidadDeDigitosPares(m);
	}

	private static boolean suPrimerDigitoEsPar(int i) {
		return ((i % 10) % 2) == 0;
	}
	
	private static int cantidadDeDigitosPares(int i) {
		int digitosPares = 0;
		while (i > 0) {
			if (suPrimerDigitoEsPar(i))
				digitosPares++;
			i /= 10;
		}
		return digitosPares;
	}

	public static Integer multiploMasGrandeDelCeroAlMilDeXEY(int x, int y) {
		int i = 1000;
		while (oBienNoEsMultiploDeOBienNoEsMultiploDe(i,x,y) && i != 0)
			i--;
		
		if (i == 0) return -1;
		else return i;
	}

	private static boolean oBienNoEsMultiploDeOBienNoEsMultiploDe(int i, int x, int y) {
		return !esMultiploDe(i, x) || !esMultiploDe(i, y);
	}

}
