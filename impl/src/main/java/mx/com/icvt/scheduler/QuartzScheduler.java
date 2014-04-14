package mx.com.icvt.scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by miguelangeldelatorre on 06/04/14.
 */
public class QuartzScheduler {

    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail newsJob = newJob(NewsTask.class)
                    .withIdentity("NewsTaskJob", "group1")
                    .build();
            Trigger newsTrigger = newTrigger()
                    .withIdentity("NewsTaskTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInHours(4)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(newsJob, newsTrigger);

            JobDetail patentsJob = newJob(PatentsTask.class)
                    .withIdentity("PatentsJob", "group1")
                    .build();
            Trigger patentsTrigger = newTrigger()
                    .withIdentity("PatentsTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInHours(4)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(patentsJob, patentsTrigger);

            JobDetail twitterJob = newJob(TwitterTask.class)
                    .withIdentity("TwitterJob", "group1")
                    .build();
            Trigger twitterTrigger = newTrigger()
                    .withIdentity("TwitterTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInHours(4)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(twitterJob, twitterTrigger);

            //scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
