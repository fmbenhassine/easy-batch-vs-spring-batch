package easybatch;

import common.Customer;
import org.easybatch.core.job.Job;
import org.easybatch.core.job.JobBuilder;
import org.easybatch.core.job.JobExecutor;
import org.easybatch.flatfile.DelimitedRecordMapper;
import org.easybatch.flatfile.FlatFileRecordReader;

import java.io.File;

/**
 * Easy Batch benchmark launcher.
 */
public class EasyBatchBenchLauncher {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        String customers = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "customers.csv";
        File customersFile = new File(customers);

        Job job = new JobBuilder()
                .reader(new FlatFileRecordReader(customersFile))
                .mapper(new DelimitedRecordMapper(Customer.class, "id", "firstName", "lastName", "birthDate", "email", "phone", "street", "zipCode", "city", "country"))
                .build();

        JobExecutor.execute(job);

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Easy Batch took: " + (elapsedTime  / 1000) + "s");

    }

}
