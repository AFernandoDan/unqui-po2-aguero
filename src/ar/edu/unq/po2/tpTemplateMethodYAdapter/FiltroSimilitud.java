package ar.edu.unq.po2.tpTemplateMethodYAdapter;

import java.util.List;

abstract public class FiltroSimilitud {
	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
		return wikipedia.stream().filter(p -> sonSimilares(page, p)).toList();
	}
	
	public abstract boolean sonSimilares(WikipediaPage pagina1, WikipediaPage pagina2);
}
