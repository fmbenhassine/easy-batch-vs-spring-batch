package springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Batch benchmark launcher.
 */
public class SpringBatchBenchLauncher {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        ApplicationContext context = new ClassPathXmlApplicationContext("customer-job.xml");
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("customerJob");
        jobLauncher.run(job, new JobParameters());

        long elapsedTime  = System.currentTimeMillis() - startTime;
        System.out.println("Spring Batch took: " + (elapsedTime  / 1000) + "s");

    }

}
