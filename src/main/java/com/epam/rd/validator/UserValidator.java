package com.epam.rd.validator;

import com.epam.rd.entity.Account;
import com.epam.rd.exception.InvalidAccountNameInputException;

public interface UserValidator {
    boolean isValidUser(Account account);
}
