package mx.com.icvt.scheduler;

import mx.com.icvt.extraction.ProcesoExtraccionNoticias;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class NewsTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ProcesoExtraccionNoticias pen = new ProcesoExtraccionNoticias();
        pen.extraerNoticias();
    }
}
