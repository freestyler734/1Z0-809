package com.company.exceptionsAndAssertions.exceptions;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exceptions {

    public static void method() throws SQLException, DateTimeParseException { }

    public static void multiCatchMethod()  throws SQLException, DateTimeParseException {
        try {
            method();
        } catch (SQLException | DateTimeParseException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void rethrowMethod()  throws SQLException, DateTimeParseException {
        try {
            method();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        // ПРОВЕРЯЕМОГО исключения не м.б. в телк try
//        try{
//
//        } catch (IOException e) {
//
//        }


        // Типы в multi-catch, как и в обычном catch не могут повторяться
//        try {
//
//        } catch (ClassCastException  e) {
//
//        }catch (ClassCastException | IllegalArgumentException e){
//
//        }


        // try-with-resources
//        try(Scanner s = new Scanner(System.in);
//            InputStream in = new BufferedInputStream(System.in);
//            ) {
//
//            s.nextInt();
//
//        } catch (Exception e) {
//            //s.nextInt(); // недоступно. Ресурс был закрыт
//        } finally {
//            //s.nextInt(); // недоступно. Ресурс был закрыт
//        }

        // SuppressedException
        try (AutoClosableExample a1 = new AutoClosableExample("1");
             AutoClosableExample a2 = new AutoClosableExample("2")) {
            System.out.println("process");
            throw new RuntimeException("RT Exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception's caught");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable t: e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        } finally {
            System.out.println("finally");
        }




    }
}


