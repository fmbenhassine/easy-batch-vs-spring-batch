package easybatch;

import common.Tweet;
import org.easybatch.core.api.Engine;
import org.easybatch.core.filter.HeaderRecordFilter;
import org.easybatch.core.impl.EngineBuilder;
import org.easybatch.flatfile.DelimitedRecordMapper;
import org.easybatch.flatfile.FlatFileRecordReader;

import java.io.File;

/**
 * Easy Batch launcher.
 */
public class EasyBatchHelloWorldLauncher {

    public static void main(String[] args) throws Exception {

        File tweets = new File(EasyBatchHelloWorldLauncher.class.getResource("/tweets.csv").toURI());

        // Build an easy batch engine
        Engine engine = new EngineBuilder()
                .reader(new FlatFileRecordReader(tweets))
                .filter(new HeaderRecordFilter())
                .mapper(new DelimitedRecordMapper<Tweet>(Tweet.class, new String[]{"id", "user", "message"}))
                .processor(new TweetProcessor()).build();

        // Run easy batch engine
        engine.call();

    }

}
