package com.epam.rd.console;

import com.epam.rd.entity.Record;
import com.epam.rd.exception.NoRecordFoundForThisUserBasedOnUrlInput;
import com.epam.rd.service.RecordServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteRecordMenu implements Menu {
    private static final Logger logger = LogManager.getLogger(DeleteRecordMenu.class);

    @Autowired
    RecordServiceImpl recordServiceImpl;
    @Autowired
    RecordInput recordInput;

    private String url;

    @Override
    public void displayMenu() throws Exception {
        logger.info("-------Delete Record Details---------");
        List<Record> recordList = recordServiceImpl.findAllRecords();
        if (recordList != null) {
            recordList.forEach(System.out::println);
            url = recordInput.getUrlInput();
            Record record = new Record();
            record.setUrl(url);
            Record fetchRecord = recordServiceImpl.findRecordBasedOnUrl(record);
            if (fetchRecord != null) {
                if (recordServiceImpl.deleteRecordBasedOnUrl(record)) {
                    logger.info("Record deleted Successfully!!!");
                } else {
                    logger.info("unable to delete record!!!");
                }
            } else {
                throw new NoRecordFoundForThisUserBasedOnUrlInput();
            }
        }
    }
}
