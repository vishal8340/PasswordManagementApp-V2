package com.epam.rd.validator;

import com.epam.rd.entity.Record;
import com.epam.rd.enums.RecordEnum;
import com.epam.rd.exception.InvalidRecordValidatorException;
import com.epam.rd.factory.RecordValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class RecordValidatorTest {
    @Autowired
    RecordValidatorFactory recordValidatorFactory;

    @Qualifier("UserNameValidator")
    @Autowired
    RecordValidator recordValidator;

    @Test
    @DisplayName("username should be minimum of 5 chars")
    void userNameShouldHaveMinimumLengthOfFiveCharacters() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should be minimum of 5 chars1")
    void userNameShouldHaveMinimumLengthOfFiveCharacters1() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGR00", "", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should be maximum of 20 chars")
    void userNameShouldHaveMaximumLengthOfTwentyCharacters() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGR00961TYPPIPQOIUYTP", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should be maximum of 20 chars1")
    void userNameShouldHaveMaximumLengthOfTwentyCharacters1() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGR00961TYPPIPQOIUYT", "", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should contains upper case chars and digit")
    void userNameShouldContainsUpperCaseAndDigit() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGR009517", "", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should contains upper case chars, digit and may be lower case")
    void userNameShouldContainsUpperCaseAndDigit1() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGRas009517", "", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should not contains only upper case")
    void userNameShouldNotContainsOnlyUpperCaseCharacters() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGRPITE", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should not contains only digit")
    void userNameShouldNotContainsOnlyDigits() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("1236461", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should not contains only small case and digit")
    void userNameShouldNotContainsSmallCaseCharacter() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("asd009517", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("username should not contains whitespace")
    void userNameShouldNotContainsBlankSpace() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.USER_NAME);
        Record record = new Record("KGR 009517", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should be minimum of 5 chars")
    void passwordShouldHaveMinimumLengthOfFiveCharacters() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should be not be null")
    void passwordShouldNotBeNUll() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "null", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should be minimum of 5 chars1")
    void passwordShouldHaveMinimumLengthOfFiveCharacters1() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "Vishi8340", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should be maximum of 20 chars")
    void passwordShouldHaveMaximumLengthOfTwentyCharacters() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "Vishi834019IUYTP12341", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should be maximum of 20 chars1")
    void passwordShouldHaveMaximumLengthOfTwentyCharacters1() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "Vishi834019IUYTP1234", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should contains upper case chars, lower case chars and digit")
    void passwordShouldContainsUpperCaseAndDigit() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "Vishi834019", "", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should not contains only upper case")
    void passwordShouldNotContainsOnlyUpperCaseCharacters() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "VISHIKR", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should not contains only digit")
    void passwordShouldNotContainsOnlyDigits() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "1236461", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should not contains small case")
    void passwordShouldNotContainsSmallCaseCharacter() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "vishikr", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("password should not contains whitespace")
    void passwordShouldNotContainsBlankSpace() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.PASSWORD);
        Record record = new Record("", "Vishi 834019", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should not be blank")
    void urlShouldNotBeBlank() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should not be null")
    void urlShouldNotBeNull() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "null", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should be in specified format")
    void urlShouldBeInSpecifiedFormat() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "www.google.com", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should be in specified format1")
    void urlShouldBeInSpecifiedFormat1() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "http://www.google.com", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should be in specified format2")
    void urlShouldBeInSpecifiedFormat2() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "https://www.google.com", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should be in specified format4")
    void urlShouldBeInSpecifiedFormat4() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "www.AWSE.in", "");
        Assertions.assertTrue(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("url should not be in other format")
    void urlShouldNotBeInOtherFormat() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "google.com", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("notes should not be blank")
    void notesShouldNotBeBlank() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("notes should not be null")
    void notesShouldNotBeNull() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "", "null");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("notes should be minimum length of five character")
    void notesShouldBeMinimumLengthOfFiveCharacter() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "", "");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("notes should be maximum length of thirty character")
    void notesShouldBeMaximumLengthOfThirtyCharacter() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "", "qwertyqwertyqwertyqwertyqwertyqwerty");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }

    @Test
    @DisplayName("notes can be in any format")
    void notesCanBeInAnyFormat() throws InvalidRecordValidatorException {
        recordValidator = recordValidatorFactory.getRecordValidate(RecordEnum.URL);
        Record record = new Record("", "", "", "Ahsjh&765#$5jghak");
        Assertions.assertFalse(recordValidator.isValidRecord(record));
    }
}
