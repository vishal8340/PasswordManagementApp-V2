package com.epam.rd.console;

import com.epam.rd.entity.Account;
import com.epam.rd.enums.UserEnum;
import com.epam.rd.exception.*;
import com.epam.rd.factory.UserValidatorFactory;
import com.epam.rd.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class UserInput {
    private static final Logger logger = LogManager.getLogger(UserInput.class);

    private String accountName;
    private String userName;
    private String password;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    UserValidatorFactory userValidatorFactory;

    public String getAccountNameInput() throws IOException, InvalidUserValidatorException, InvalidAccountNameInputException {
        logger.info("AccountName: ");
        accountName = bufferedReader.readLine();
        UserValidator userValidator = userValidatorFactory.getUserValidate(UserEnum.ACCOUNT_NAME);
        Account account = new Account();
        account.setAccountName(accountName);
        if (userValidator.isValidUser(account)) {
            return accountName;
        }
        throw new InvalidAccountNameInputException();
    }

    public String getUserNameInput() throws IOException, InvalidUserValidatorException, InvalidUserNameInputException, InvalidAccountNameInputException {
        logger.info("UserName: ");
        userName = bufferedReader.readLine();
        UserValidator userValidator = userValidatorFactory.getUserValidate(UserEnum.USER_NAME);
        Account account = new Account();
        account.setUserName(userName);
        if (userValidator.isValidUser(account)) {
            return userName;
        }
        throw new InvalidUserNameInputException();
    }

    public String getPasswordInput() throws IOException, InvalidUserValidatorException, InvalidPasswordInputException {
        logger.info("Password: ");
        password = bufferedReader.readLine();
        UserValidator userValidator = userValidatorFactory.getUserValidate(UserEnum.PASSWORD);
        Account account = new Account();
        account.setPassword(password);
        if (userValidator.isValidUser(account)) {
            return password;
        }
        throw new InvalidPasswordInputException();
    }
}
