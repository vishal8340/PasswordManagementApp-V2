package com.epam.rd.exception;

public class AccountAlreadyExistsException extends Exception {
    public AccountAlreadyExistsException() {
        super("Oops! Account Already Exists....!Try again");
    }
}
