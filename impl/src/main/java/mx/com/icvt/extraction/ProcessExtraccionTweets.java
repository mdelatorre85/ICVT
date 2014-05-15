package mx.com.icvt.extraction;

import mx.com.icvt.extraction.impl.twitter.TwitterDataExtractor;
import mx.com.icvt.extraction.impl.twitter.TwitterExtractorConfiguration;
import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import mx.com.icvt.persistence.impl.tweets.ConfiguracionExtraccionTweets;
import mx.com.icvt.persistence.impl.tweets.TweetsDataPersister;
import mx.com.icvt.persistence.impl.tweets.TweetsDataRetriever;

import java.util.LinkedList;
import java.util.List;

public class ProcessExtraccionTweets {
    public void extraeTweets(){
        TwitterDataExtractor extractor;
        TwitterExtractorConfiguration cfg;
        TwitterResultData resultData;
        List<ConfiguracionExtraccionTweets> configuraciones;
        List<TwitterResultData> results;

        extractor = new TwitterDataExtractor();
        configuraciones = obtenerConfiguracionesExtraccion();
        results = new LinkedList<TwitterResultData>();

        for (ConfiguracionExtraccionTweets configuracion : configuraciones){
            cfg = configuracion.getConfiguration();
            resultData = extractor.extract(cfg);
            System.out.printf("Se encontraron %d tweets\n", resultData.getResults().size());
            results.add(resultData);
        }

        persistExtractionResults(results);
    }

    private List<ConfiguracionExtraccionTweets> obtenerConfiguracionesExtraccion(){
        return new TweetsDataRetriever().getAllConfigurations();
    }

    private void persistExtractionResults(List<TwitterResultData> results){
        TweetsDataPersister persister = new TweetsDataPersister();
        for (TwitterResultData result : results){
            persister.persist(result);
        }
    }
}
