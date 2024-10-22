package com.fatma.Leader_Acadmy.exception;

public class RecordNotCorrectException extends RuntimeException{
    public RecordNotCorrectException() {
        super();
    }

    public RecordNotCorrectException(String message) {
        super(message);
    }
}
