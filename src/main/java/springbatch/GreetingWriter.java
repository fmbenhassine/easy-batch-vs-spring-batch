package springbatch;

import common.Greeting;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Spring Batch greeting writer.
 */
public class GreetingWriter implements ItemWriter<Greeting> {

    @Override
    public void write(List<? extends Greeting> items) throws Exception {
        // no op
    }

}
