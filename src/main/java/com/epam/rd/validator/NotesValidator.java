package com.epam.rd.validator;

import com.epam.rd.entity.Record;
import org.springframework.stereotype.Component;

@Component
public class NotesValidator implements RecordValidator {
    @Override
    public boolean isValidRecord(Record record) {
        return (record.getNotes().length() > 5 && record.getNotes().length() < 100) && checkNullAndBlankInput(record.getNotes());
    }

    static boolean checkNullAndBlankInput(String input) {
        return input != null && !input.equals("");
    }
}
