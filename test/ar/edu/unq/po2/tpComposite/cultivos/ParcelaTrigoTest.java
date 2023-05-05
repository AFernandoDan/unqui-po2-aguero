package ar.edu.unq.po2.tpComposite.cultivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ParcelaTrigoTest {
	@Test
	public void unaParcelaDeTrigoPorSiSolaDaUnaProduccionAnualDe300() {
		ParcelaTrigo unaParcelaTrigo = new ParcelaTrigo();
		assertEquals(unaParcelaTrigo.getProduccionAnual(), 300);
	}
}
