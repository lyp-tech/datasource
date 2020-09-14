package testbatchapp1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IncomingRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomingRecordId;
    private String incomingRecord;
    private Long sequenceNo;
    private Boolean isCompleteDuplicate;

    public IncomingRecord(String incomingRecord, Long sequenceNo){
        this.incomingRecord = incomingRecord;
        this.sequenceNo = sequenceNo;
    }

    public IncomingRecord(String incomingRecord, Long sequenceNo, Boolean isCompleteDuplicate){
        this.incomingRecord = incomingRecord;
        this.sequenceNo = sequenceNo;
        this.isCompleteDuplicate = isCompleteDuplicate;
    }

    @Override
    public String toString() {
        return incomingRecord;
    }
}
