package easybatch;

import org.easybatch.core.processor.RecordProcessor;
import org.easybatch.core.record.GenericRecord;
import org.easybatch.core.record.Record;

import common.Tweet;

/**
 * Easy Batch tweet processor.
 */
public class TweetProcessor implements RecordProcessor<Record<Tweet>, Record<Tweet>> {

    @Override
    public Record<Tweet> processRecord(Record<Tweet> record) {
        Tweet tweet = record.getPayload();
        tweet.setMessage(tweet.getMessage().toUpperCase());
        return new GenericRecord<>(record.getHeader(), tweet);
    }

}
