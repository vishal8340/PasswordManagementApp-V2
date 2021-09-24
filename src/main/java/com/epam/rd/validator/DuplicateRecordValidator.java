package com.epam.rd.validator;

import com.epam.rd.entity.Record;
import com.epam.rd.service.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateRecordValidator implements RecordValidator {
    @Autowired
    RecordServiceImpl recordServiceImpl;

    @Override
    public boolean isValidRecord(Record record) {
        return recordServiceImpl.isRecordExists(record);
    }
}
