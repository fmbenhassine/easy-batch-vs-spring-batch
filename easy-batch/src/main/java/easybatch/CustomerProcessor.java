package easybatch;

import common.Customer;
import org.easybatch.core.processor.RecordProcessor;
import org.easybatch.core.record.GenericRecord;
import org.easybatch.core.record.Record;

/**
 * Easy Batch customer processor.
 */
public class CustomerProcessor implements RecordProcessor<Record<Customer>, Record<Customer>> {

    @Override
    public Record<Customer> processRecord(Record<Customer> record) {
        Customer customer = record.getPayload();
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customer.setLastName(customer.getLastName().toUpperCase());
        customer.setCountry(customer.getCountry().toUpperCase());
        customer.setCity(customer.getCity().toUpperCase());
        customer.setStreet(customer.getStreet().toUpperCase());
        customer.setZipCode(customer.getZipCode().toUpperCase());
        return new GenericRecord<>(record.getHeader(), customer);
    }

}
