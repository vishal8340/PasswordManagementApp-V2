package com.epam.rd.exception;

public class NoRecordFoundForThisUserBasedOnUrlInput extends Exception {
    public NoRecordFoundForThisUserBasedOnUrlInput() {
        super("Oops! No Record Found For Input Url...");
    }
}
