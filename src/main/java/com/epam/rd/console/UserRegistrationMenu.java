package com.epam.rd.console;

import com.epam.rd.entity.Account;
import com.epam.rd.exception.*;
import com.epam.rd.service.AccountServiceImpl;
import com.epam.rd.validator.DuplicateAccountValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserRegistrationMenu implements Menu {

    private static final Logger logger = LogManager.getLogger(UserRegistrationMenu.class);

    private String accountName;
    private String userName;
    private String password;

    @Autowired
    UserInput userInput;

    @Autowired
    DuplicateAccountValidator duplicateAccountValidatorObj;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Override
    public void displayMenu() throws Exception {
        logger.info("------Registration Details------");
        accountName = userInput.getAccountNameInput();
        userName = userInput.getUserNameInput();
        password = userInput.getPasswordInput();

        Account account = new Account(accountName, userName, password);
        if (!duplicateAccountValidatorObj.isAccountExists(account)) {
            if (accountServiceImpl.registerAccount(account)) {
                logger.info("User Registration Successfully!!!");
            } else {
                logger.info("Unable to register!! Try again.");
            }
        } else {
            throw new AccountAlreadyExistsException();
        }
    }
}
