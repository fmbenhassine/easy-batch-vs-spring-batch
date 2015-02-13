package easybatch;

import org.easybatch.core.api.RecordProcessor;

import common.Tweet;

/**
 * Easy Batch tweet processor.
 */
public class TweetProcessor implements RecordProcessor<Tweet, Tweet> {

    @Override
    public Tweet processRecord(Tweet tweet) throws Exception {
        System.out.println(tweet);
        return tweet;
    }

}
