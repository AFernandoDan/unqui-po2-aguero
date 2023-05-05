package ar.edu.unq.po2.tpComposite.fileSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DirectoryTest {
	private Directory unDirectorio, unDirectorioConUnNodo, unDirectorioConVariosNodos;
	private DirectoryNode unNodo, unNodoMasViejo;

	@BeforeEach
	public void setUp() {
		unDirectorio = new Directory("miDirectorio");
		unDirectorioConUnNodo = new Directory("miDirectorioConUnNodo");
		unDirectorioConVariosNodos = new Directory("miDirectorioConVariosNodos");
		
		unNodo = mock(DirectoryNode.class);
		when(unNodo.totalSize()).thenReturn(100);
		when(unNodo.getStructure(1)).thenReturn("un archivo");
		when(unNodo.getLastModificationDate()).thenReturn(LocalDateTime.now());
		
		unNodoMasViejo = mock(DirectoryNode.class);
		when(unNodoMasViejo.getLastModificationDate()).thenReturn(LocalDateTime.of(2022, 11, 24, 15, 50, 50, 1));
		
		String estructuraDeNodo =
				"un directorio/" +
				"\n\t\totro archivo" +
				"\n\t\totro directorio/" +
				"\n\t\t\tun archivo dentro de otro directorio";
		
		when(unNodoMasViejo.getStructure(1)).thenReturn(estructuraDeNodo);
		
		unDirectorioConUnNodo.addNode(unNodo);
		unDirectorioConVariosNodos.addNode(unNodo);
		unDirectorioConVariosNodos.addNode(unNodoMasViejo);
	}
	
	@Test
	public void unDirectorioSabeSuFechaDeCreacion() {
		unDirectorio = new Directory("miDirectorio");
		assertEquals(LocalDateTime.now(), unDirectorio.getCreationDate());
	}
	
	@Test
	public void elPesoTotalDeUnDirectorioNuevoEsVacio() {
		assertEquals(0, unDirectorio.totalSize());
	}
	
	@Test
	public void unDirectorioNuevoEstaVacioDeContenido() {
		Set<DirectoryNode> contenidoEsperado = Set.of();
		assertEquals(contenidoEsperado, unDirectorio.getContent());
	}
	
	@Test
	public void unDirectorioAgregaUnNodo() {
		Set<DirectoryNode> contenidoEsperado = Set.of(unNodo);
		assertEquals(contenidoEsperado, unDirectorioConUnNodo.getContent());
	};
	
	@Test
	public void unDirectorioAumentaElTamanioAlAgregarUnNodo() {
		assertEquals(100, unDirectorioConUnNodo.totalSize());
		verify(unNodo).totalSize();
	}
	
	@Test
	public void elElementoMasViejoYMasNuevoDeUnDirectorioConUnSoloNodoEsEseMismo() {
		assertEquals(unNodo, unDirectorioConUnNodo.lastModifed());
		assertEquals(unNodo, unDirectorioConUnNodo.oldestElement());
	}
	
	@Test
	public void unDirectorioConVariosNodosSabeCualEsElMasNuevoYElMasAtiguo() {
		assertEquals(unNodo, unDirectorioConVariosNodos.lastModifed());
		assertEquals(unNodoMasViejo, unDirectorioConVariosNodos.oldestElement());
		
		verify(unNodo, times(2)).getLastModificationDate();
		verify(unNodoMasViejo, times(2)).getLastModificationDate();
	}
	
	@Test
	public void laEstructuraDeUnDirectorioSinContenidoEsRaiz() {
		assertEquals("miDirectorio/", unDirectorio.getStructure(0));
	}
	
	@Test
	public void laEstructuraDeUnDirectorioConContenido() {
		String estructuraEsperada =
				"miDirectorioConVariosNodos/\n" +
				"	un directorio/\n" +
				"		otro archivo\n" +
				"		otro directorio/\n" +
				"			un archivo dentro de otro directorio\n" +
				"	un archivo";
		assertEquals(estructuraEsperada, unDirectorioConVariosNodos.getStructure(0));
		unDirectorioConVariosNodos.printStructure();
	}
}
