package com.epam.rd.console;

import com.epam.rd.entity.Record;
import com.epam.rd.exception.RecordDoesNotExistException;
import com.epam.rd.service.RecordServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViewRecordMenu implements Menu {
    private static final Logger logger = LogManager.getLogger(ViewRecordMenu.class);

    @Autowired
    RecordServiceImpl recordServiceImpl;

    @Override
    public void displayMenu() throws Exception {
        logger.info("------Display Record Details-------");
        List<Record> recordList = recordServiceImpl.findAllRecords();
        if (recordList != null && !recordList.isEmpty()) {
            recordList.forEach(System.out::println);
        } else {
            throw new RecordDoesNotExistException();
        }
    }
}
