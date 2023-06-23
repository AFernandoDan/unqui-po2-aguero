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

import ar.edu.unq.po2.tpTemplateMethodYAdapter.LinkEnComun;
import ar.edu.unq.po2.tpTemplateMethodYAdapter.WikipediaPage;

public class LinkEnComunTest {
	private WikipediaPage paginaOpenAI, paginaDeepMind, paginaUniverso, paginaIA, paginaBigBang;
	private List<WikipediaPage> unaWikipedia, similarPages;
	private LinkEnComun lec;
	
	@Before
	public void setUp() {
		paginaIA = mock(WikipediaPage.class);
		paginaBigBang = mock(WikipediaPage.class);
		
		paginaOpenAI = mock(WikipediaPage.class);
		when(paginaOpenAI.getLinks()).thenReturn(Arrays.asList(paginaIA));
		
		paginaDeepMind = mock(WikipediaPage.class);
		when(paginaDeepMind.getLinks()).thenReturn(Arrays.asList(paginaIA));
		
		paginaUniverso = mock(WikipediaPage.class);
		when(paginaUniverso.getLinks()).thenReturn(Arrays.asList(paginaBigBang));
		
		unaWikipedia = Arrays.asList(paginaDeepMind, paginaUniverso);
		similarPages = Arrays.asList(paginaDeepMind);
		
		lec = new LinkEnComun();
	}
	
	@Test
	public void unFiltroSabeSiDosPaginasSonSimilaresSiTienenAlgunLinkEnComun() {
		assertTrue(lec.sonSimilares(paginaOpenAI, paginaDeepMind));
		assertFalse(lec.sonSimilares(paginaOpenAI, paginaUniverso));
	}
	
	@Test
	public void unFiltroSabeCualesPaginasSonSimilaresAUnaDadaSiCoinicidenEnAlgunoDeSusLinks() {
		List <WikipediaPage> unaWikipediaNoRelacionadaConUniverso = Arrays.asList(paginaOpenAI, paginaDeepMind);
		
		assertEquals(lec.getSimilarPages(paginaOpenAI, unaWikipedia), similarPages);
		assertTrue(lec.getSimilarPages(paginaUniverso, unaWikipediaNoRelacionadaConUniverso).isEmpty());
	}
}
