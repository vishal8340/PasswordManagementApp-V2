package com.epam.rd.validator;

import com.epam.rd.entity.Account;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component("AccountNameValidator")
public class AccountNameValidator implements UserValidator {
    private final String ACCOUNT_NAME_REGEX = "^[a-zA-Z_ ]{5,20}$";

    @Override
    public boolean isValidUser(Account account) {
        return Pattern.matches(ACCOUNT_NAME_REGEX, account.getAccountName()) && checkNullAndBlankInput(account.getAccountName());
    }

    static boolean checkNullAndBlankInput(String input) {
        return input != null && !input.equals("");
    }
}

