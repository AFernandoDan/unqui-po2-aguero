package ar.edu.unq.po2.tpComposite.fileSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DirectoryNodeTest {
	private DirectoryNode unNodo;
	
	@BeforeEach
	public void setUp() {
		unNodo = new File("miNodo", 200);
	}
	
	@Test
	public void unNodoTieneNombre() {
		assertEquals("miNodo", unNodo.getName());
	};
	
	@Test
	public void unNodoDeUnDirectorioSabeCuandoSeLeHizoLaUltimaModificacion() {
		unNodo = new File("miNodo", 100);
		assertEquals(LocalDateTime.now(), unNodo.getLastModificationDate());
	}
	
	@Test
	public void unArchivoSeModificaYCambiaSuLaFechaDeUltimaModificacion() throws InterruptedException {
		LocalDateTime dateBeforeModification = LocalDateTime.now();
		Thread.sleep(1);
		unNodo.setName("miNodoModificado");
		assertNotEquals(dateBeforeModification, unNodo.getLastModificationDate());
	}
}
