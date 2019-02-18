package com.company.exceptionsAndAssertions.exceptions.myExceptions;

public class MyOwnError extends Error {

    MyOwnError(){
        super();
    }

    MyOwnError(Throwable cause){
        super(cause);
    }

    MyOwnError(String msg){
        super(msg);
    }

    MyOwnError(String msg, Throwable cause){
        super(msg, cause);
    }
}
