package ar.edu.unq.po2.tpTemplateMethodYAdapter;

public class MismaLetraInicial extends FiltroSimilitud {

	public boolean sonSimilares(WikipediaPage pagina1, WikipediaPage pagina2) {
		return pagina1.getTitle().startsWith(getLetraInicial(pagina2));
	}

	private String getLetraInicial(WikipediaPage pagina) {
		return pagina.getTitle().substring(0, 1);
	}

}
