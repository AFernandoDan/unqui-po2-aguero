package ar.edu.unq.po2.tpComposite.cultivos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParcelaMixtaTest {
	private ParcelaMixta unaParcelaMixta, unaParcelaMixtaNoVacia, unaParcelaLlena;
	private ParcelaProductiva otraParcela, otraParcela2;
	
	@BeforeEach
	public void setUp() {
		unaParcelaMixta = new ParcelaMixta();
		unaParcelaLlena = new ParcelaMixta();
		unaParcelaMixtaNoVacia = new ParcelaMixta();
		
		otraParcela = mock(ParcelaTrigo.class);
		when(otraParcela.getProduccionAnual()).thenReturn((double) 300);
		
		otraParcela2 = mock(ParcelaSoja.class);
		when(otraParcela2.getProduccionAnual()).thenReturn((double) 500);
		
		unaParcelaLlena.agregarParcela(otraParcela);
		unaParcelaLlena.agregarParcela(otraParcela);
		unaParcelaLlena.agregarParcela(otraParcela);
		unaParcelaLlena.agregarParcela(otraParcela);
		
		unaParcelaMixtaNoVacia.agregarParcela(otraParcela);
	}

	@Test
	public void unaParcelaMixtaPorSiSolaDaUnaProduccionAnualDe0() {
		assertEquals(unaParcelaMixta.getProduccionAnual(), 0);
	}
	
	@Test
	public void unaParcelaMixtaVaciaAgregaUnaParcelaSuProduccionAnualLaQueYaTeniaMasEsUnCuartoDeLaProduccionDeLaOtraParcela() {
		
		unaParcelaMixta.agregarParcela(otraParcela);
		unaParcelaMixta.agregarParcela(otraParcela2);
		
		assertEquals(unaParcelaMixta.getProduccionAnual(), 200);
		verify(otraParcela).getProduccionAnual();
		verify(otraParcela2).getProduccionAnual();
	}
	
	@Test
	public void unaParcelaMixtaEstaLlenaCuandoAgregoCuatroParcelas() {
		unaParcelaMixta.agregarParcela(otraParcela);
		unaParcelaMixta.agregarParcela(otraParcela);
		unaParcelaMixta.agregarParcela(otraParcela);
		assertFalse(unaParcelaMixta.estaLlena());
		
		unaParcelaMixta.agregarParcela(otraParcela);
		assertTrue(unaParcelaMixta.estaLlena());
	}
	
	@Test
	public void alAgregarUnaParcelaAUnaParcelaMixtaLlenaSimplementeNoSeAgregaYLaProduccionEsLaMisma() {
		ParcelaProductiva quintaParcela = mock(ParcelaProductiva.class);
		when(quintaParcela.getProduccionAnual()).thenReturn((double) 500);


		assertEquals(unaParcelaLlena.getProduccionAnual(), 300);

		unaParcelaLlena.agregarParcela(otraParcela);
		assertEquals(unaParcelaLlena.getProduccionAnual(), 300);
		verify(quintaParcela, never()).getProduccionAnual();
	}
	
	@Test
	public void aUnaParcelaMixtaVaciaSeLeBorraUnaParcelaNoSucedeNadaSuProduccionAnualEsLaMisma() {
		assertEquals(unaParcelaMixta.getProduccionAnual(), 0);
		
		unaParcelaMixta.borrarParcela(otraParcela);
		
		assertEquals(unaParcelaMixta.getProduccionAnual(), 0);
	}
	
	@Test
	public void aUnaParcelaMixtaNoVaciaSeLeBorraUnaParcelaSuProduccionAnualSeReduce() {
		assertEquals(unaParcelaMixtaNoVacia.getProduccionAnual(), 75);
		
		unaParcelaMixtaNoVacia.borrarParcela(otraParcela);
		
		assertEquals(unaParcelaMixtaNoVacia.getProduccionAnual(), 0);
	}
}
