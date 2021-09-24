package com.epam.rd.console;

import com.epam.rd.enums.RecordOperationEnum;
import com.epam.rd.factory.RecordMenuFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class RecordConsoleMenu implements Menu {
    private static final Logger logger = LogManager.getLogger(RecordConsoleMenu.class);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    RecordMenuFactory recordMenuFactory;

    @Override
    public void displayMenu() throws Exception {
        int choice;
        do {
            logger.info("------Record Operation Menu------");
            logger.info("1. Add Record");
            logger.info("2. Update Record");
            logger.info("3. View Record");
            logger.info("4. Delete Record");
            logger.info("5. Main Menu");

            choice = getOption(bufferedReader);
            RecordOperationEnum selectedMenuOption = RecordOperationEnum.getRecordMenuEnum(choice);
            Menu selectedMenu = recordMenuFactory.getRecordOperationMenu(selectedMenuOption);
            try {
                selectedMenu.displayMenu();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        } while (choice != 5);
    }

    private static int getOption(BufferedReader bufferedReader) throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
}
