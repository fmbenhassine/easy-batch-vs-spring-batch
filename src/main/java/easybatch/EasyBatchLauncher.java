package easybatch;

import common.Greeting;
import io.github.benas.easybatch.core.impl.EasyBatchEngine;
import io.github.benas.easybatch.core.impl.EasyBatchEngineBuilder;
import io.github.benas.easybatch.flatfile.FlatFileRecordReader;
import io.github.benas.easybatch.flatfile.dsv.DelimitedRecordMapper;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Easy Batch launcher.
 */
public class EasyBatchLauncher {

    public static void main(String[] args) throws FileNotFoundException {

        // Build an easy batch engine
        EasyBatchEngine easyBatchEngine = new EasyBatchEngineBuilder()
                .registerRecordReader(new FlatFileRecordReader(new File(args[0])))
                .registerRecordMapper(new DelimitedRecordMapper<Greeting>(Greeting.class, new String[]{"id", "name"}))
                .registerRecordProcessor(new GreetingProcessor()).build();

        // Run easy batch engine
        easyBatchEngine.call();

    }

}
