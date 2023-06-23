package ar.edu.unq.po2.tpTemplateMethodYAdapter.cuentaBancaria;

import java.util.ArrayList;
import java.util.List;

// abstract class (template-method)
public abstract class CuentaBancaria {
	private String titular;
	private int saldo;
	private List<String> movimientos;
	 
	public CuentaBancaria(String titular){
		this.titular=titular;
		this.saldo=0;
		this.movimientos= new ArrayList<String>();
	}
	 
	public String getTitular(){
		return this.titular;
	}
	
	public int getSaldo(){
		return this.saldo;
	}
	
	protected void setSaldo(int monto){
		this.saldo=monto;
	}
	
	public void agregarMovimientos(String movimiento){
		this.movimientos.add(movimiento);
	}
	
	// template-method
	public final void extraer(int monto) {
		if(puedeExtraer(monto)){
			this.setSaldo(this.getSaldo()-monto);
			this.agregarMovimientos("Extraccion");
		}
	}

	// primitive operation
	protected abstract boolean puedeExtraer(int monto);
}
