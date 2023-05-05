package ar.edu.unq.po2.tp5;

import java.util.ArrayList;

public class CajaRegistradora {
	
	private Agencia agencia;
	
	public CajaRegistradora(Agencia agencia) {
		setAgencia(agencia);
	}
	
	private Agencia getAgencia() {
		return agencia;
	}

	private void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	private float registrar(Registrable registrable) {
		return registrable.registrarseCon(getAgencia());
	}
	
	public float registrarProductosDe(ArrayList<Registrable> registrables) {
	    float montoTotal = 0;
	    for (Registrable registrable: registrables) {
	    	montoTotal += registrar(registrable);
	    }
	    return montoTotal;
	}
}
