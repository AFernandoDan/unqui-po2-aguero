package ar.edu.unq.po2.tpTemplateMethodYAdapter;

public class LinkEnComun extends FiltroSimilitud {

	@Override
	public boolean sonSimilares(WikipediaPage pagina1, WikipediaPage pagina2) {
		return pagina1.getLinks().stream().anyMatch(p -> pagina2.getLinks().contains(p));
	}

}
