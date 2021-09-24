package com.epam.rd.factory;

import com.epam.rd.enums.RecordEnum;
import com.epam.rd.exception.InvalidRecordValidatorException;
import com.epam.rd.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordValidatorFactory {
    @Autowired
    UserNameValidator userNameValidator;

    @Autowired
    PasswordValidator passwordValidator;

    @Autowired
    UrlValidator urlValidator;

    @Autowired
    NotesValidator notesValidator;

    public RecordValidator getRecordValidate(RecordEnum recordEnum) throws InvalidRecordValidatorException {
        switch (recordEnum) {
            case USER_NAME:
                return userNameValidator;
            case PASSWORD:
                return passwordValidator;
            case URL:
                return urlValidator;
            case NOTES:
                return notesValidator;
        }
        throw new InvalidRecordValidatorException();
    }
}
