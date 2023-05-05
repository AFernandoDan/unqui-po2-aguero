package ar.edu.unq.po2.tpComposite.cultivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ParcelaSojaTest {
	@Test
	public void unaParcelaDeSojaPorSiSolaDaUnaProduccionAnualDe500() {
		ParcelaSoja unaParcelaSoja = new ParcelaSoja();
		assertEquals(unaParcelaSoja.getProduccionAnual(), 500);
	}
}
