package com.epam.rd.validator;

import com.epam.rd.entity.Account;
import com.epam.rd.entity.Record;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component("UserNameValidator")
public class UserNameValidator implements UserValidator, RecordValidator {
    private final String USER_NAME_REGEX = "(?=.*[A-Z])(?=.*[0-9])(?=\\S+$).{5,20}$";

    @Override
    public boolean isValidUser(Account account) {
        return Pattern.matches(USER_NAME_REGEX, account.getUserName()) && checkNullAndBlankInput(account.getUserName());
    }

    static boolean checkNullAndBlankInput(String input) {
        return input != null && !input.equals("");
    }

    @Override
    public boolean isValidRecord(Record record) {
        return Pattern.matches(USER_NAME_REGEX, record.getUserName()) && checkNullAndBlankInput(record.getUserName());

    }
}