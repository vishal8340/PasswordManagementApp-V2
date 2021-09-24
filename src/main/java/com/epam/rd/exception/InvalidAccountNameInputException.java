package com.epam.rd.exception;

public class InvalidAccountNameInputException extends Exception {
    public InvalidAccountNameInputException() {
        super("Oops! Invalid AccountName");
    }
}
