package com.epam.rd.validator;

import com.epam.rd.entity.Account;
import com.epam.rd.repository.AccountRepositoryImpl;
import com.epam.rd.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateAccountValidator implements AccountValidator {
    @Autowired
    AccountServiceImpl accountServiceImplObj;

    @Override
    public boolean isAccountExists(Account account) {
        return accountServiceImplObj.isAccountExists(account);
    }
}
