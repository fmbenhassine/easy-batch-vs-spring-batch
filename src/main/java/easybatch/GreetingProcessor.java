package easybatch;

import common.Greeting;
import io.github.benas.easybatch.core.api.AbstractRecordProcessor;

/**
 * Easy Batch greeting processor.
 */
public class GreetingProcessor extends AbstractRecordProcessor<Greeting> {

    @Override
    public void processRecord(Greeting greeting) throws Exception {
        System.out.println(greeting.getGreetingMessage());
    }

}
