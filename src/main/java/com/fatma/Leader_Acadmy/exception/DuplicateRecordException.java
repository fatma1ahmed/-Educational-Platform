package com.fatma.Leader_Acadmy.exception;

public class DuplicateRecordException extends RuntimeException{
    public DuplicateRecordException() {
        super();
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
