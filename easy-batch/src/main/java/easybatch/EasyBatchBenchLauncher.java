package easybatch;

import common.Customer;
import org.easybatch.core.job.Job;
import org.easybatch.core.job.JobBuilder;
import org.easybatch.core.job.JobExecutor;
import org.easybatch.core.writer.FileRecordWriter;
import org.easybatch.flatfile.DelimitedRecordMapper;
import org.easybatch.flatfile.DelimitedRecordMarshaller;
import org.easybatch.flatfile.FlatFileRecordReader;

import java.io.File;

/**
 * Easy Batch benchmark launcher.
 */
public class EasyBatchBenchLauncher {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        File datasource = new File(getTempDir() + "customers_in.csv");
        File datasink = new File(getTempDir() + "customers_out.csv");
        String[] fields = {"id", "firstName", "lastName", "birthDate", "email", "phone", "street", "zipCode", "city", "country"};

        Job job = new JobBuilder()
                .reader(new FlatFileRecordReader(datasource))
                .mapper(new DelimitedRecordMapper<>(Customer.class, fields))
                .processor(new CustomerProcessor())
                .marshaller(new DelimitedRecordMarshaller<>(Customer.class,fields))
                .writer(new FileRecordWriter(datasink))
                .batchSize(10)
                .build();

        JobExecutor jobExecutor = new JobExecutor();
        jobExecutor.execute(job);
        jobExecutor.shutdown();

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Easy Batch took: " + (elapsedTime  / 1000) + "s");

    }

    private static String getTempDir() {
        return System.getProperty("java.io.tmpdir") + System.getProperty("file.separator");
    }

}
