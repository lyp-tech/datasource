package testbatchapp1;

import batchcore.IncomingRecordStep;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class IncomingRecordStepImpl implements IncomingRecordStep {


    @Override
    public Step getStep(DataSource dataSource,StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("step1")
                .<IncomingRecord, IncomingRecord>chunk(10000)
                .reader(reader())
                .processor(processor())
                .writer(writer(dataSource))
                .build();
    }

    @Bean
    public FlatFileItemReader<IncomingRecord> reader() {
        return new FlatFileItemReaderBuilder<IncomingRecord>()
                .lineMapper(new CustomLineMapper())
                .name("personItemReader")
                .resource(new ClassPathResource("test.csv"))
                .build();
    }

    @Bean
    public IncomingRecordItemProcessor processor() {
        return new IncomingRecordItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<IncomingRecord> writer(DataSource dataSource) {
        String sql = "INSERT INTO incoming_record (incoming_record, sequence_no, is_complete_duplicate) " +
                "VALUES (:incomingRecord, :sequenceNo, :isCompleteDuplicate)";

        return new JdbcBatchItemWriterBuilder<IncomingRecord>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(sql)
                .dataSource(dataSource)
                .build();
    }


}
