package com.epam.rd.service;

import com.epam.rd.entity.Account;

public interface AccountService {
    boolean registerAccount(Account account);

    boolean isAccountExists(Account account);

    String validateLogin(Account account);
}
