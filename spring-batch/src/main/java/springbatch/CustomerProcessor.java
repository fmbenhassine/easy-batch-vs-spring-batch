package springbatch;

import org.springframework.batch.item.ItemProcessor;

import common.Customer;

/**
 * Spring Batch customer processor.
 */
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }

}