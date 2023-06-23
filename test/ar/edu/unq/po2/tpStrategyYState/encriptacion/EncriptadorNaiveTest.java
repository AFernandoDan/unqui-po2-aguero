package ar.edu.unq.po2.tpStrategyYState.encriptacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpStrategyYState.encriptacion.EncriptadorNaive;
import ar.edu.unq.po2.tpStrategyYState.encriptacion.MetodoEncriptacion;
import ar.edu.unq.po2.tpStrategyYState.encriptacion.MetodoOrden;

public class EncriptadorNaiveTest {
	private EncriptadorNaive unEncriptadorNaiveOrden;
	private MetodoEncriptacion metodoOrden;
	private String textoAEncriptar, textoEncriptado, textoADesencriptar, textoDesencriptado;
	
	@BeforeEach
	public void setUp() {
		metodoOrden = mock(MetodoOrden.class);
		textoAEncriptar = "Se que aquel angel para los finales llora esa flor que no dejamos ser";
		textoEncriptado = "que Se angel aquel los para llora finales flor esa no que ser dejamos";
		textoADesencriptar = textoEncriptado;
		textoDesencriptado = textoAEncriptar;
		when(metodoOrden.encriptar(textoAEncriptar)).thenReturn(textoEncriptado);
		when(metodoOrden.desencriptar(textoADesencriptar)).thenReturn(textoDesencriptado);
		unEncriptadorNaiveOrden = new EncriptadorNaive(metodoOrden); 
	}
	
	@Test
	public void unEncriptadorNaiveRecibeUnMetodoDeEncriptacionEncriptaUnTexto() {
		assertEquals(textoEncriptado, unEncriptadorNaiveOrden.encriptar(textoAEncriptar));
	}
	
	@Test
	public void unEncriptadorNaiveRecibeUnMetodoDeEncriptacionDesencriptaUnTexto() {
		assertEquals(textoDesencriptado, unEncriptadorNaiveOrden.desencriptar(textoADesencriptar));
	}
}
