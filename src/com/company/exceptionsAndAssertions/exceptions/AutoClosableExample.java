package com.company.exceptionsAndAssertions.exceptions;

public class AutoClosableExample implements AutoCloseable {

    String num;

    AutoClosableExample(String num) {
        this.num = num;
    }

    @Override
    public void close() throws IllegalArgumentException {
        System.out.println("closed " + num);
        throw new IllegalArgumentException("AutoClosableExample" + num + " Exception" );
    }
}
