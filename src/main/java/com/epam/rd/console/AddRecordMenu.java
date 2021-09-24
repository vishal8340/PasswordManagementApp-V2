package com.epam.rd.console;

import com.epam.rd.entity.Record;
import com.epam.rd.exception.RecordAlreadyExistsException;
import com.epam.rd.service.RecordServiceImpl;
import com.epam.rd.validator.DuplicateRecordValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddRecordMenu implements Menu {
    private static final Logger logger = LogManager.getLogger(AddRecordMenu.class);

    private String userName;
    private String password;
    private String url;
    private String notes;

    @Autowired
    RecordInput recordInput;

    @Autowired
    DuplicateRecordValidator duplicateRecordValidatorObj;

    @Autowired
    RecordServiceImpl recordServiceImpl;

    @Override
    public void displayMenu() throws Exception {
        logger.info("------Add Record Details------");
        userName = recordInput.getUserNameInput();
        password = recordInput.getPasswordInput();
        url = recordInput.getUrlInput();
        notes = recordInput.getNotesInput();

        Record record = new Record(userName, password, url, notes);
        if (!duplicateRecordValidatorObj.isValidRecord(record)) {
            if (recordServiceImpl.addRecord(record)) {
                logger.info("Record Added Successfully!!!");
            } else {
                logger.info("Unable to add Record!!!");
            }
        } else {
            throw new RecordAlreadyExistsException();
        }
    }
}
