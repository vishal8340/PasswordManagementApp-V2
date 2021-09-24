package com.epam.rd.console;

import com.epam.rd.entity.Record;
import com.epam.rd.exception.NoRecordFoundForThisUserBasedOnUrlInput;
import com.epam.rd.exception.RecordDoesNotExistException;
import com.epam.rd.service.RecordServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateRecordMenu implements Menu {
    private static final Logger logger = LogManager.getLogger(UpdateRecordMenu.class);

    @Autowired
    RecordServiceImpl recordServiceImpl;
    @Autowired
    RecordInput recordInput;

    private String userName;
    private String password;
    private String url;
    private String notes;

    @Override
    public void displayMenu() throws Exception {
        logger.info("-------Update Record Details--------");
        List<Record> recordList = recordServiceImpl.findAllRecords();
        if (recordList != null) {
            recordList.forEach(System.out::println);
            url = recordInput.getUrlInput();
            Record record = new Record();
            record.setUrl(url);
            Record fetchRecord = recordServiceImpl.findRecordBasedOnUrl(record);
            if (fetchRecord != null) {
                userName = recordInput.getUserNameInput();
                password = recordInput.getPasswordInput();
                notes = recordInput.getNotesInput();
                record.setId(fetchRecord.getId());
                record.setUserName(userName);
                record.setPassword(password);
                record.setNotes(notes);
                if (recordServiceImpl.updateRecord(record)) {
                    logger.info("Record Updated Successfully!!!");
                } else {
                    logger.info("Unable to Update Record!!");
                }

            } else {
                throw new NoRecordFoundForThisUserBasedOnUrlInput();
            }
        } else {
            throw new RecordDoesNotExistException();
        }
    }
}
