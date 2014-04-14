package mx.com.icvt.scheduler;

import mx.com.icvt.extraction.impl.patents.PatentsDataExtractor;
import mx.com.icvt.extraction.impl.patents.PatentsExtractorConfiguration;
import mx.com.icvt.extraction.impl.patents.PatentsResultData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;

/**
 * Created by miguelangeldelatorre on 07/04/14.
 */
public class PatentsTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // TODO 1 Obtener todos los TwitterDataExtractors
        ArrayList<PatentsExtractorConfiguration> configurations = new ArrayList<PatentsExtractorConfiguration>();
        //2 Por cada TwitterDataExtractors ejecutar la extracción
        PatentsDataExtractor extractor = new PatentsDataExtractor();

        for (PatentsExtractorConfiguration config : configurations) {
            PatentsResultData results = extractor.extract(config);
            //TODO 3 Por cada TwitterDataExtractors guardar los resultados
        }

    }
}
