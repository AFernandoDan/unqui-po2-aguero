package ar.edu.unq.po2.tpTemplateMethodYAdapter.cuentaBancaria;

// concrete class (template-method)
public class CuentaCorriente extends CuentaBancaria {
	private int descubierto;
	
	public CuentaCorriente(String titular, int descubierto){
		super(titular);
		this.descubierto=descubierto;
	}
	
	public int getDescubierto(){
		return this.descubierto;
	}

	// primitive operation
	@Override
	protected boolean puedeExtraer(int monto) {
		return this.getSaldo()+this.getDescubierto()>=monto;
	}
}