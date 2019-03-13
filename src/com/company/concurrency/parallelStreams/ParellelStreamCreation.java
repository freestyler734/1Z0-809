package com.company.concurrency.parallelStreams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class ParellelStreamCreation {

    /*
        Способы создания параллельного стрима.
        Количество потоков в параллельном стриме
        определяется кол-в свободный ядер процессора
     */
    public static void main(String[] args) {

        // Конвертирование обычного стрима в параллельный
        // Необязательно получать ссылку на параллельный стрим,
        // после вызова метода стрим становится параллельным
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        System.out.println("До вызова метода parallel(): ");

        System.out.println("stream.isParallel(): " + stream.isParallel());
        Stream<Integer> parallelStream1 = stream.parallel();
        System.out.println("");

        System.out.println("После вызова метода parallel(): ");
        System.out.println("stream.isParallel(): " + stream.isParallel());
        System.out.println("parallelStream1.isParallel(): " + parallelStream1.isParallel());
        System.out.println("\n------------------------------------\n");

        // Получение ссылки на параллельный стрим из коллекции
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5).parallelStream();
        System.out.println("parallelStream2.isParallel(): " + parallelStream2.isParallel());



    }
}
