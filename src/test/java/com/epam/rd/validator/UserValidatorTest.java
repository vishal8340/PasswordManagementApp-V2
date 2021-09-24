package com.epam.rd.validator;

import com.epam.rd.entity.Account;
import com.epam.rd.exception.InvalidUserValidatorException;
import com.epam.rd.factory.UserValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.epam.rd.enums.UserEnum.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserValidatorTest {
    @Autowired
    UserValidatorFactory userValidatorFactory;

    @Qualifier("AccountNameValidator")
    @Autowired
    UserValidator userValidator;

    @Test
    @DisplayName("account name should have minimum 5 character")
    void accountNameShouldHaveMinimumLengthOfFiveCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("account name should not be null")
    void accountNameShouldNotBeNull() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("null", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("account name should have maximum 20 character")
    void accountNameShouldHaveMaximumLengthOfTwentyCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("Vishal Kumar Singh Chauhan", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("account name should only have alphabets")
    void accountNameShouldContainsOnlyAlphabet() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("123456789", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("account name should only have alphabets1")
    void accountNameShouldContainsOnlyAlphabet1() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("Vishal Kumar", "", "");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("account name should only have alphabets2")
    void accountNameShouldContainsOnlyAlphabet2() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("Vishal834019", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("account name should not have special character")
    void accountNameShouldNotContainsSpecialChars() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(ACCOUNT_NAME);
        Account account = new Account("@Vishal Kumar", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should be minimum of 5 chars")
    void userNameShouldHaveMinimumLengthOfFiveCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should be minimum of 5 chars1")
    void userNameShouldHaveMinimumLengthOfFiveCharacters1() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGR00", "");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should be maximum of 20 chars")
    void userNameShouldHaveMaximumLengthOfTwentyCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGR00961TYPPIPQOIUYTP", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should be maximum of 20 chars1")
    void userNameShouldHaveMaximumLengthOfTwentyCharacters1() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGR00961TYPPIPQOIUYT", "");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should contains upper case chars and digit")
    void userNameShouldContainsUpperCaseAndDigit() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGR009517", "");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should contains upper case chars, digit and may be lower case")
    void userNameShouldContainsUpperCaseAndDigit1() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGRas009517", "");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should not contains only upper case")
    void userNameShouldNotContainsOnlyUpperCaseCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGRPITE", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should not contains only digit")
    void userNameShouldNotContainsOnlyDigits() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "1236461", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should not contains only small case and digit")
    void userNameShouldNotContainsSmallCaseCharacter() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "asd009517", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("username should not contains whitespace")
    void userNameShouldNotContainsBlankSpace() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(USER_NAME);
        Account account = new Account("", "KGR 009517", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should be minimum of 5 chars")
    void passwordShouldHaveMinimumLengthOfFiveCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should be not be null")
    void passwordShouldNotBeNUll() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "null");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should be minimum of 5 chars1")
    void passwordShouldHaveMinimumLengthOfFiveCharacters1() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "Vishi8340");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should be maximum of 20 chars")
    void passwordShouldHaveMaximumLengthOfTwentyCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "Vishi834019IUYTP12341");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should be maximum of 20 chars1")
    void passwordShouldHaveMaximumLengthOfTwentyCharacters1() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "Vishi834019IUYTP1234");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should contains upper case chars, lower case chars and digit")
    void passwordShouldContainsUpperCaseAndDigit() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "Vishi834019");
        Assertions.assertTrue(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should not contains only upper case")
    void passwordShouldNotContainsOnlyUpperCaseCharacters() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "VISHIKR");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should not contains only digit")
    void passwordShouldNotContainsOnlyDigits() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "1236461");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should not contains small case")
    void passwordShouldNotContainsSmallCaseCharacter() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "vishikr");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }

    @Test
    @DisplayName("password should not contains whitespace")
    void passwordShouldNotContainsBlankSpace() throws InvalidUserValidatorException {
        userValidator = userValidatorFactory.getUserValidate(PASSWORD);
        Account account = new Account("", "", "Vishi 834019");
        Assertions.assertFalse(userValidator.isValidUser(account));
    }
}
