package springbatch;

import org.springframework.batch.item.ItemProcessor;

import common.Customer;

/**
 * Spring Batch customer processor.
 */
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customer.setLastName(customer.getLastName().toUpperCase());
        customer.setEmail(customer.getEmail().toUpperCase());
        customer.setCountry(customer.getCountry().toUpperCase());
        customer.setCity(customer.getCity().toUpperCase());
        customer.setStreet(customer.getStreet().toUpperCase());
        customer.setZipCode(customer.getZipCode().toUpperCase());
        return customer;
    }

}