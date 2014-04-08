package mx.com.icvt.extraction.impl.scheduler;

import mx.com.icvt.extraction.impl.news.NewsDataExtractor;
import mx.com.icvt.extraction.impl.news.NewsExtractorConfiguration;
import mx.com.icvt.extraction.impl.news.NewsResultData;
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
        //2 Por cada TwitterDataExtractors ejecutar la extracción
        NewsDataExtractor extractor = new NewsDataExtractor();

        for (NewsExtractorConfiguration config : configurations) {
            NewsResultData results = extractor.extract(config);
            //TODO 3 Por cada TwitterDataExtractors guardar los resultados
        }

    }
}
