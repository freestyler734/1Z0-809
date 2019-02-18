package com.company.exceptionsAndAssertions.exceptions.myExceptions;

public class MyOwnRuntimeException extends RuntimeException {

    MyOwnRuntimeException(){
        super();
    }

    MyOwnRuntimeException(Exception cause) {
        super(cause);
    }

    MyOwnRuntimeException(String msg){
        super(msg);
    }

    MyOwnRuntimeException(String msg, Exception cause){
        super(msg, cause);
    }
}
