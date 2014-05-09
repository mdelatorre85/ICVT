package mx.com.icvt.extraction;

import mx.com.icvt.extraction.impl.news.NewsDataExtractor;
import mx.com.icvt.extraction.impl.news.NewsExtractorConfiguration;
import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias;
import mx.com.icvt.persistence.impl.news.NewsDataPersister;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

import java.util.LinkedList;
import java.util.List;

public class ProcesoExtraccionNoticias {
    public void extraerNoticias() {
        NewsDataExtractor extractor = new NewsDataExtractor();
        List<NewsResultData> results = new LinkedList<NewsResultData>();
        NewsExtractorConfiguration cfg;
        List<ConfiguracionExtraccionNoticias> configuraciones;

        configuraciones = obtenerConfiguracionExtraccion();

        for (ConfiguracionExtraccionNoticias configuracion : configuraciones){
            cfg = new NewsExtractorConfiguration(configuracion.getTerminoBusqueda());
            cfg.setId(configuracion.getId());
            results.add(extractor.extract(cfg));
        }

        persistExtractionResults(results);
    }

    private List<ConfiguracionExtraccionNoticias> obtenerConfiguracionExtraccion() {
        return new NewsDataRetriever().getAllConfigurations();
    }

    private void persistExtractionResults(List<NewsResultData> results){
        NewsDataPersister persister = new NewsDataPersister();
        for (NewsResultData result : results){
            persister.persist(result);
        }
    }
}
