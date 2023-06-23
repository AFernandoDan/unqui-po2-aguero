package ar.edu.unq.po2.tpRefactorings.cuenta;

public abstract class CuentaBancaria {
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected int saldo;
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public final void extraer(Integer monto) {
		if (puedeExtraer(monto)) {
			reducirSaldo(monto);
			guardarMovimientoYNotificar("Extracción", monto);
		}
	}

	private void guardarMovimientoYNotificar(String movimiento, Integer monto) {
		this.historialDeMovimientos.registrarMovimiento(movimiento, monto);
		this.notificador.notificarNuevoSaldoACliente(this);
	}

	protected abstract boolean puedeExtraer(Integer monto);

	private void reducirSaldo(Integer monto) {
		this.saldo = saldo - monto;
	}
}
