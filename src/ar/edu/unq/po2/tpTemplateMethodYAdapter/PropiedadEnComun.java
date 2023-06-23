package ar.edu.unq.po2.tpTemplateMethodYAdapter;

public class PropiedadEnComun extends FiltroSimilitud{

	@Override
	public boolean sonSimilares(WikipediaPage pagina1, WikipediaPage pagina2) {
		return pagina1
				.getInfobox()
				.keySet()
				.stream()
				.anyMatch(k -> pagina2.getInfobox().containsKey(k));
	}

}
