package com.epam.rd;

import com.epam.rd.console.Menu;
import com.epam.rd.enums.MenuEnum;
import com.epam.rd.exception.InvalidConsoleInputException;
import com.epam.rd.exception.NoConsoleInputException;
import com.epam.rd.factory.ConsoleMenuFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class SpringPasswordManagementApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringPasswordManagementApplication.class);

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, NoConsoleInputException, InvalidConsoleInputException {
        ApplicationContext context = SpringApplication.run(SpringPasswordManagementApplication.class, args);

        ConsoleMenuFactory consoleMenuFactory = context.getBean(ConsoleMenuFactory.class);

        int choice;
        do {
            logger.info("*****Password Management System*****");
            logger.info("1. Login");
            logger.info("2. New Registration");
            logger.info("3. Exit");

            choice = getOption(bufferedReader);
            MenuEnum selectedMenuOption = MenuEnum.getConsoleMenuEnum(choice);
            Menu selectedMenu = consoleMenuFactory.getConsoleMenu(selectedMenuOption);
            try {
                selectedMenu.displayMenu();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        } while (choice != 3);
        logger.info("*****Thank You! Visit Again*****");
    }

    private static int getOption(BufferedReader bufferedReader) throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
}
