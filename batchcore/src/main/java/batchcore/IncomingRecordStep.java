package batchcore;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public abstract interface IncomingRecordStep {

    public abstract Step getStep(DataSource dataSource, StepBuilderFactory stepBuilderFactory);

}
