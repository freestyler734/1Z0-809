package com.company.exceptionsAndAssertions.exceptions.myExceptions;

public class MyOwnCheckedException extends Exception {

    MyOwnCheckedException(){
        super();
    }

    MyOwnCheckedException(Exception cause) {
        super(cause);
    }

    MyOwnCheckedException(String msg) {
        super(msg);
    }

    MyOwnCheckedException(String msg, Exception cause) {
        super(msg, cause);
    }
}
