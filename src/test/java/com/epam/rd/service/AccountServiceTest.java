package com.epam.rd.service;

import com.epam.rd.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import com.epam.rd.repository.AccountRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @InjectMocks
    AccountServiceImpl accountServiceImpl;
    @Mock
    AccountRepositoryImpl accountRepositoryImpl;

    @Test
    @DisplayName("account should be exist based on userName")
    public void accountShouldBeExistBasedOnUserName() {
        when(accountRepositoryImpl.existsByUserName(any())).thenReturn(false);
        Account account = new Account("", "", "");
        Assertions.assertFalse(accountServiceImpl.isAccountExists(account));
    }

    @Test
    @DisplayName("account should be exist based on userName")
    public void accountShouldBeExistBasedOnUserName1() {
        when(accountRepositoryImpl.existsByUserName(any())).thenReturn(true);
        Account account = new Account("", "", "");
        Assertions.assertTrue(accountServiceImpl.isAccountExists(account));
    }

    @Test
    @DisplayName("account should be validate based on userName and password")
    public void accountShouldBeValidateBasedOnUserNameAndPassword() {
        Account account1 = new Account("", "", "");
        Account account = new Account("", "KGR009517", "Vishal834019");

        when(accountRepositoryImpl.findByUserName(any())).thenReturn(account1);
        Assertions.assertEquals("invalidPassword", accountServiceImpl.validateLogin(account));
    }

    @Test
    @DisplayName("account should be validate based on userName and password")
    public void accountShouldBeValidateBasedOnUserNameAndPassword1() {
        Account account1 = new Account("Vishal Kumar", "KGR009517", "Vishal834019");
        Account account = new Account("Vishal Kumar", "KGR009517", "Vishal834019");

        when(accountRepositoryImpl.findByUserName(any())).thenReturn(account1);
        Assertions.assertEquals(account1, accountRepositoryImpl.findByUserName(account.getUserName()));
    }

    @Test
    @DisplayName("account should be registered")
    public void accountShouldBeRegistered() {
        Account account1 = new Account("", "", "");
        Account account = new Account("Vishal Kumar", "KGR009517", "Vishal834019");
        when(accountRepositoryImpl.save(any())).thenReturn(account1);
        Assertions.assertNotNull(accountServiceImpl.registerAccount(account));
    }

    @Test
    @DisplayName("account should be registered")
    public void accountShouldBeRegistered1() {
        Account account = new Account("Vishal Kumar", "KGR009517", "Vishal834019");
        when(accountRepositoryImpl.save(any())).thenReturn(null);
        Assertions.assertFalse(accountServiceImpl.registerAccount(account));
    }
}
