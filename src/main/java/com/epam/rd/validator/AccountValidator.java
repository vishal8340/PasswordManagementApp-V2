package com.epam.rd.validator;

import com.epam.rd.entity.Account;

public interface AccountValidator {
    boolean isAccountExists(Account account);
}
