package testbatchapp1;

import batchcore.BaseBatchConfiguration;
import batchcore.IncomingRecordStep;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class TestBatchConfig extends BaseBatchConfiguration {

    @Autowired
    public IncomingRecordStep incomingRecordStep;

}
