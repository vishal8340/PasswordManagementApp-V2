package com.epam.rd.exception;

public class RecordAlreadyExistsException extends Exception {
    public RecordAlreadyExistsException() {
        super("Oops! Record Already Exists For Input Url..!Try again");
    }
}
