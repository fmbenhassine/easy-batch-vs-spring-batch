package easybatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import org.easybatch.core.impl.Engine;
import org.easybatch.core.impl.EngineBuilder;
import org.easybatch.flatfile.FlatFileRecordReader;
import org.easybatch.flatfile.dsv.DelimitedRecordMapper;

import common.Customer;

/**
 * Easy Batch benchmark launcher.
 */
public class EasyBatchBenchLauncher {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {

        long startTime = System.currentTimeMillis();

        String customers = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "customers.csv";
        File customersFile = new File(customers);

        Engine engine = new EngineBuilder()
                .reader(new FlatFileRecordReader(customersFile))
                .mapper(new DelimitedRecordMapper<Customer>(Customer.class
                        , new String[]{"id", "firstName", "lastName", "birthDate", "email", "phone", "street", "zipCode", "city", "country"}))
                .processor(new CustomerProcessor()).build();

        engine.call();

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Easy Batch took: " + (elapsedTime  / 1000) + "s");

    }

}
