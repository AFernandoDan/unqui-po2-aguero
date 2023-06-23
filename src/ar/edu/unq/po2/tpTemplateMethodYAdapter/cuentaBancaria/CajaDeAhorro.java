package ar.edu.unq.po2.tpTemplateMethodYAdapter.cuentaBancaria;

import java.util.ArrayList;
import java.util.Enumeration;

//concrete class (template-method)
public class CajaDeAhorro extends CuentaBancaria {
	private int limite;
	
	public CajaDeAhorro(String titular, int limite){
		super(titular);
		this.limite=limite;
	}
	
	public int getLimite(){
		return this.limite;
	}

	// primitive operation
	@Override
	protected boolean puedeExtraer(int monto) {
		return this.getSaldo()>=monto && this.getLimite()>=monto;
	}

}

