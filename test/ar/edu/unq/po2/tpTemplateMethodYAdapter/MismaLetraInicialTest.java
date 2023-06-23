package ar.edu.unq.po2.tpTemplateMethodYAdapter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpTemplateMethodYAdapter.MismaLetraInicial;
import ar.edu.unq.po2.tpTemplateMethodYAdapter.WikipediaPage;

public class MismaLetraInicialTest {
	WikipediaPage paginaAliexpress, paginaArgentina, paginaIguazu;
	MismaLetraInicial mli;
	List<WikipediaPage> unaWikipedia, similarPages;
	
	@Before
	public void setUp() {
		paginaAliexpress = mock(WikipediaPage.class);
		when(paginaAliexpress.getTitle()).thenReturn("Aliexpress");
		
		paginaArgentina = mock(WikipediaPage.class);
		when(paginaArgentina.getTitle()).thenReturn("Argentina");
		
		paginaIguazu = mock(WikipediaPage.class);
		when(paginaIguazu.getTitle()).thenReturn("Iguazu");
		
		unaWikipedia = Arrays.asList(paginaAliexpress, paginaIguazu);
		similarPages = Arrays.asList(paginaAliexpress);
		
		mli = new MismaLetraInicial();
	}
	
	@Test
	public void unFiltroSabeSiDosPaginasSonSimilaresSiTienenLaMismaLetraInicialEnElTitulo() {
		assertTrue(mli.sonSimilares(paginaAliexpress, paginaArgentina));
		assertFalse(mli.sonSimilares(paginaAliexpress, paginaIguazu));
	}
	
	@Test
	public void unFiltroSabeCualesPaginasSonSimilaresAUnaDadaSiCoinicidenEnSuLetraInicialEnElTitulo() {
		assertEquals(mli.getSimilarPages(paginaArgentina, unaWikipedia), similarPages);
	}
}