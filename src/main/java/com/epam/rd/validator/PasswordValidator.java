package com.epam.rd.validator;

import com.epam.rd.entity.Account;
import com.epam.rd.entity.Record;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordValidator implements UserValidator, RecordValidator {
    private String PASSWORD_REGEX = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=\\S+$).{5,20}$";

    @Override
    public boolean isValidUser(Account account) {
        return Pattern.matches(PASSWORD_REGEX, account.getPassword()) && checkNullAndBlankInput(account.getPassword());
    }

    static boolean checkNullAndBlankInput(String input) {
        return input != null && !input.equals("");
    }

    @Override
    public boolean isValidRecord(Record record) {
        return Pattern.matches(PASSWORD_REGEX, record.getPassword()) && checkNullAndBlankInput(record.getPassword());

    }
}
