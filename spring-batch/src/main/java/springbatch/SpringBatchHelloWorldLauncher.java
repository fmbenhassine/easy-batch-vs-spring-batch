package springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Batch hellow world launcher.
 */
public class SpringBatchHelloWorldLauncher {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("job-hello-world.xml");

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        Job job = (Job) context.getBean("helloWorldJob");

        jobLauncher.run(job, new JobParameters());

    }

}
