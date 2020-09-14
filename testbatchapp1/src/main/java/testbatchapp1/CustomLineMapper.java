package testbatchapp1;

import lombok.AllArgsConstructor;
import org.springframework.batch.item.file.LineMapper;

@AllArgsConstructor
public class CustomLineMapper implements LineMapper {

    @Override
    public IncomingRecord mapLine(String line, int lineNumber) throws Exception {
        return new IncomingRecord(line, Long.valueOf(lineNumber));
    }
}