DROP TABLE IF EXISTS incoming_record;
DROP TABLE IF EXISTS validated_person;
DROP TABLE IF EXISTS NATURAL_ID;
DROP TABLE IF EXISTS NAME;
DROP TABLE IF EXISTS PERSON_DETAILS;
DROP TABLE IF EXISTS PERSON;

CREATE TABLE incoming_record  (
    incoming_record_id BIGINT NOT NULL PRIMARY KEY auto_increment,
    incoming_record VARCHAR(1000),
    sequence_no BIGINT,
    is_complete_duplicate BOOLEAN
);
