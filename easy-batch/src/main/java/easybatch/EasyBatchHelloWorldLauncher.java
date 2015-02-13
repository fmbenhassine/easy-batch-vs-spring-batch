package easybatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import common.Tweet;

import org.easybatch.core.filter.HeaderRecordFilter;
import org.easybatch.core.impl.Engine;
import org.easybatch.core.impl.EngineBuilder;
import org.easybatch.flatfile.FlatFileRecordReader;
import org.easybatch.flatfile.dsv.DelimitedRecordMapper;

/**
 * Easy Batch launcher.
 */
public class EasyBatchHelloWorldLauncher {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {

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
