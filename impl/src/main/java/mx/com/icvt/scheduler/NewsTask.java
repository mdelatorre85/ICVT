package mx.com.icvt.scheduler;

import mx.com.icvt.extraction.impl.news.NewsDataExtractor;
import mx.com.icvt.extraction.impl.news.NewsExtractorConfiguration;
import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.persistence.impl.news.NewsDataPersister;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 07/04/14.
 */
public class NewsTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // TODO 1 Obtener todos los TwitterDataExtractors
        ArrayList<NewsExtractorConfiguration> configurations = new ArrayList<NewsExtractorConfiguration>();
        //2 Por cada NewsDataExtractors ejecutar la extracción
        NewsDataExtractor extractor = new NewsDataExtractor();

        for (NewsExtractorConfiguration config : configurations) {
            NewsResultData results = extractor.extract(config);
            NewsDataPersister dataPersister = new NewsDataPersister();
            dataPersister.persist(results);
        }

    }
}
