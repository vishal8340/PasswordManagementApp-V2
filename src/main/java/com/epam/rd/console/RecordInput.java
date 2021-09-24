package com.epam.rd.console;

import com.epam.rd.entity.Record;
import com.epam.rd.enums.RecordEnum;
import com.epam.rd.exception.*;
import com.epam.rd.factory.RecordValidatorFactory;
import com.epam.rd.validator.RecordValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class RecordInput {
    private static final Logger logger = LogManager.getLogger(RecordInput.class);

    private String userName;
    private String password;
    private String url;
    private String notes;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    RecordValidatorFactory recordValidatorFactory;

    public String getUserNameInput() throws IOException, InvalidUserValidatorException, InvalidUserNameInputException, InvalidRecordValidatorException {
        logger.info("UserName: ");
        userName = bufferedReader.readLine();
        RecordValidator recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record();
        record.setUserName(userName);
        if (recordValidator.isValidRecord(record)) {
            return userName;
        }
        throw new InvalidUserNameInputException();
    }

    public String getPasswordInput() throws IOException, InvalidUserValidatorException, InvalidPasswordInputException, InvalidRecordValidatorException {
        logger.info("Password: ");
        password = bufferedReader.readLine();
        RecordValidator recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record();
        record.setPassword(password);
        if (recordValidator.isValidRecord(record)) {
            return password;
        }
        throw new InvalidPasswordInputException();
    }

    public String getUrlInput() throws InvalidRecordValidatorException, IOException, InvalidUrlInputException {
        logger.info("Url: ");
        url = bufferedReader.readLine();
        RecordValidator recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record();
        record.setUrl(url);
        if (recordValidator.isValidRecord(record)) {
            return url;
        }
        throw new InvalidUrlInputException();
    }

    public String getNotesInput() throws IOException, InvalidRecordValidatorException, InvalidNotesInputException {
        logger.info("Notes: ");
        notes = bufferedReader.readLine();
        RecordValidator recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.NOTES);
        Record record = new Record();
        record.setNotes(notes);
        if (recordValidator.isValidRecord(record)) {
            return notes;
        }
        throw new InvalidNotesInputException();
    }
}
