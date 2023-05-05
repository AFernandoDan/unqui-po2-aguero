package ar.edu.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaRegistradoraTest {
	private Recaudadora unaRecaudadora;
	private CajaRegistradora unaCajaReg;
	private Producto producto1, producto2;
	private ArrayList<Registrable> registrables;
	private Registrable factura1, factura2;
	
	@BeforeEach
	public void setUp() {
		unaRecaudadora = new Recaudadora();
		unaCajaReg = new CajaRegistradora(unaRecaudadora);
		producto1 = new ProductoTradicional("CocaCola", 100f, 5);
		producto2 = new ProductoCooperativa("Papas PEPE", 100f, 10);
		registrables = new ArrayList<Registrable>();
		factura1 = new Servicio("Netflix", 100, 3);
		factura2 = new Impuesto("IRPF", 100);
	}
	
	@Test
	public void elMontoAlRegistrarNadaEs0() {
		assertEquals(0, unaCajaReg.registrarProductosDe(registrables));
	}
	
	@Test
	public void registrandoProductosDeUnaListaConProductos() {
		registrables.add(producto1);
		registrables.add(producto2);
		assertEquals(5, producto1.getStock());
		assertEquals(10, producto2.getStock());
		
		float
			precioProd1 = 100f,
			precioProd2 = 90f,
			montoEsperado = precioProd1 + precioProd2;
		
		assertEquals(montoEsperado, unaCajaReg.registrarProductosDe(registrables));
		assertEquals(4, producto1.getStock());
		assertEquals(9, producto2.getStock());
	}
	
	@Test
	public void registrandoFacturas() {
		registrables.add(factura1);
		registrables.add(factura2);
		
		float
			precioFact1 = 300f,
			precioFact2 = 100f,
			montoEsperado = precioFact1 + precioFact2;
		
		assertEquals(montoEsperado, unaCajaReg.registrarProductosDe(registrables));
	}
}
