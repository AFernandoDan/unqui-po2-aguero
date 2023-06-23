package ar.edu.unq.po2.tpTemplateMethodYAdapter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpTemplateMethodYAdapter.WikipediaPage;

public class PropiedadEnComunTest {
	WikipediaPage paginaAliexpress, paginaArgentina, paginaIguazu;
	PropiedadEnComun pec;
	List<WikipediaPage> unaWikipedia, similarPages, unaWikipediaSinRelacionConAli;
	
	@Before
	public void setUp() {
		Map<String, WikipediaPage>
			infoboxAli = new HashMap<String, WikipediaPage>(),
			infoboxIguazu = new HashMap<String, WikipediaPage>(),
			infoboxArg = new HashMap<String, WikipediaPage>();
		
		infoboxAli.put("empresa", mock(WikipediaPage.class));
		infoboxIguazu.put("provincia", mock(WikipediaPage.class));
		infoboxArg.put("provincia", mock(WikipediaPage.class));
		
		paginaAliexpress = mock(WikipediaPage.class);
		when(paginaAliexpress.getInfobox()).thenReturn(infoboxAli);
		
		paginaArgentina = mock(WikipediaPage.class);
		when(paginaArgentina.getInfobox()).thenReturn(infoboxArg);
		
		paginaIguazu = mock(WikipediaPage.class);
		when(paginaIguazu.getInfobox()).thenReturn(infoboxIguazu);
		
		unaWikipedia = Arrays.asList(paginaAliexpress, paginaIguazu);
		similarPages = Arrays.asList(paginaIguazu);
		unaWikipediaSinRelacionConAli = Arrays.asList(paginaArgentina, paginaIguazu);
		
		pec = new PropiedadEnComun();
	}
	
	@Test
	public void unFiltroSabeSiDosPaginasSonSimilaresSiTienenAlgunaPropiedadEnComunEnElInfobox() {
		assertTrue(pec.sonSimilares(paginaIguazu, paginaArgentina));
		assertFalse(pec.sonSimilares(paginaAliexpress, paginaIguazu));
		assertFalse(pec.sonSimilares(paginaAliexpress, paginaArgentina));
	}
	
	@Test
	public void unFiltroSabeCualesPaginasSonSimilaresAUnaDadaSiCoinicidenEnAlgunoDeSusClavesDelInfobox( ) { 
		assertEquals(pec.getSimilarPages(paginaArgentina, unaWikipedia), similarPages);
		assertTrue(pec.getSimilarPages(paginaAliexpress, unaWikipediaSinRelacionConAli).isEmpty());
	}
}
