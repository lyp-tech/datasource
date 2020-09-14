package testbatchapp1;

import org.springframework.batch.item.ItemProcessor;

import java.util.HashSet;

public class IncomingRecordItemProcessor implements ItemProcessor<IncomingRecord,IncomingRecord> {
    private HashSet duplicateComplete = new HashSet();

    @Override
    public IncomingRecord process(IncomingRecord incomingRecord) throws Exception {
        Boolean isDuplicate = isIncomingRecordDuplicate(incomingRecord);

        final String incomingRecordString = incomingRecord.getIncomingRecord().toUpperCase();
        final Long sequenceNo = incomingRecord.getSequenceNo();
        final IncomingRecord transformedIncomingRecord = new IncomingRecord(incomingRecordString, sequenceNo, isDuplicate);

        return transformedIncomingRecord;
    }

    private Boolean isIncomingRecordDuplicate(IncomingRecord incomingRecord) {
        Boolean isDuplicate = false;

        if(duplicateComplete.contains(incomingRecord.toString()))
            isDuplicate = true;
        else
            duplicateComplete.add(incomingRecord.toString());

        return isDuplicate;
    }
}
