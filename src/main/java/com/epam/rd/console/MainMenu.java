package com.epam.rd.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MainMenu implements Menu {
    private static final Logger logger = LogManager.getLogger(ExitMenu.class);

    @Override
    public void displayMenu() throws Exception {
        logger.info("-------Switching to Main Menu--------");
    }
}
