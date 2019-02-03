package com.company.functionalProgramming.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStream {

    public static void main(String[] args) {
        IntStream intStream = IntStream.empty();
        LongStream longStream = LongStream.of(1,2,3);
        DoubleStream doubleStream = DoubleStream.iterate(0., d -> d + 0.1);

        // Дополнительные методы создания
        // range(start, end(не вкл.)), rangeClosed(start, end(вкл.))
        intStream = IntStream.range(0, 5);
        intStream.forEach(System.out::print);
        System.out.println("");
        longStream = LongStream.range(4, 9);
        longStream.forEach(System.out::print);
        System.out.println("\n-");
        intStream = IntStream.rangeClosed(0, 5);
        intStream.forEach(System.out::print);
        System.out.println("");
        longStream = LongStream.rangeClosed(4, 9);
        longStream.forEach(System.out::print);


    }
}
