package springbatch;

import java.util.List;
import org.springframework.batch.item.ItemWriter;

import common.Customer;

/**
 * Spring Batch customer writer.
 */
public class CustomerWriter implements ItemWriter<Customer> {

    @Override
    public void write(List<? extends Customer> items) throws Exception {
        // no op
    }

}
