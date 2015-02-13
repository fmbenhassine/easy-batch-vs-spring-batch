package springbatch;

import java.util.List;
import org.springframework.batch.item.ItemWriter;

import common.Tweet;

/**
 * Spring Batch tweet writer.
 */
public class TweetWriter implements ItemWriter<Tweet> {

    @Override
    public void write(List<? extends Tweet> items) throws Exception {
        // no op
    }

}
