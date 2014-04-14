package mx.com.icvt.scheduler;

import mx.com.icvt.extraction.impl.twitter.TwitterDataExtractor;
import mx.com.icvt.extraction.impl.twitter.TwitterExtractorConfiguration;
import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 07/04/14.
 */
public class TwitterTask implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // TODO 1 Obtener todos los TwitterDataExtractors
        ArrayList<TwitterExtractorConfiguration> configurations = new ArrayList<TwitterExtractorConfiguration>();
        //2 Por cada TwitterDataExtractors ejecutar la extracción
        TwitterDataExtractor extractor = new TwitterDataExtractor();

        for (TwitterExtractorConfiguration config : configurations) {
            TwitterResultData results = extractor.extract(config);
            //TODO 3 Por cada TwitterDataExtractors guardar los resultados
        }

    }
}
