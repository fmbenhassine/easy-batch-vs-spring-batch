package springbatch;

import common.Greeting;
import org.springframework.batch.item.ItemProcessor;

/**
 * Spring Batch greeting processor.
 */
public class GreetingProcessor implements ItemProcessor<Greeting, Greeting> {

    @Override
    public Greeting process(Greeting item) throws Exception {
        System.out.println(item.getGreetingMessage());
        return item;
    }

}