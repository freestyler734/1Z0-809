package com.company.exceptionsAndAssertions.exceptions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.DateTimeException;
import java.util.Scanner;

public class Exceptions {

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
        try(Scanner s = new Scanner(System.in);
            InputStream in = new BufferedInputStream(System.in);
            ) {

            s.nextInt();

        } catch (Exception e) {
            //s.nextInt(); // недоступно. Ресурс был закрыт
        } finally {
            //s.nextInt(); // недоступно. Ресурс был закрыт
        }

    }
}
