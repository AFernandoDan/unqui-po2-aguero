package ar.edu.unq.po2.tpComposite.fileSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileTest {
	File unArchivo;
	
	@BeforeEach
	public void setUp() {
		unArchivo = new File("miArchivo", 100);
	}
	
	@Test
	public void unAchivoTieneTamanio() {
		assertEquals(100, unArchivo.totalSize());
	};
	
	@Test
	public void unArchivoTieneUnaEstructura() {
		assertEquals("miArchivo", unArchivo.getStructure(0));
	}
}
