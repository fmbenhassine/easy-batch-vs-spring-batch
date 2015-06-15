package easybatch;

import org.easybatch.core.api.RecordProcessor;

import common.Customer;

/**
 * Easy Batch customer processor.
 */
public class CustomerProcessor implements RecordProcessor<Customer, Customer> {

    @Override
    public Customer processRecord(Customer customer) {
        return customer;
    }

}
