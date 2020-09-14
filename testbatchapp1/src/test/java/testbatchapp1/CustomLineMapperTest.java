package testbatchapp1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomLineMapperTest {

    @Test
    void mapLine() throws Exception{
        String line = "";
        int lineNumber = 1;

        CustomLineMapper customLineMapper = new CustomLineMapper();
        IncomingRecord incomingRecordResult = customLineMapper.mapLine(line,lineNumber);
        assertEquals(line,incomingRecordResult.getIncomingRecord());
        assertEquals(lineNumber,incomingRecordResult.getSequenceNo());
    }
}