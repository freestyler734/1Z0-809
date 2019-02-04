package com.company.functionalProgramming.stream;

import java.time.LocalDate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    public static void main(String[] args) {
        IntStream intStream = IntStream.empty();
        LongStream longStream = LongStream.of(1,2,3);
        DoubleStream doubleStream = DoubleStream.iterate(0., d -> d + 0.1);

        /// Дополнительные методы создания///
        // range(start, end(не вкл.)), rangeClosed(start, end(вкл.))
        // range(start, end(не вкл.))
        intStream = IntStream.range(0, 5);
        intStream.forEach(System.out::print);
        System.out.println("");
        longStream = LongStream.range(4, 9);
        longStream.forEach(System.out::print);
        System.out.println("\n-");

        // rangeClosed(start, end(вкл.))
        intStream = IntStream.rangeClosed(0, 5);
        intStream.forEach(System.out::print);
        System.out.println("");
        longStream = LongStream.rangeClosed(4, 9);
        longStream.forEach(System.out::print);
        System.out.println("-----------------------------------");



        /// Примеры конвертирования стримов в другие типы с помощью map ///
        // Stream к др. типам
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = stream.map(intObject -> intObject + 1); // Function<? super T, ? extends R> mapper
        intStream = stream.mapToInt(intObject -> intObject.intValue()); // ToIntFunction<? super T> mapper
        longStream = stream.mapToLong(intObject -> intObject.longValue()); // ToLongFunction<? super T> mapper
        doubleStream = stream.mapToDouble(intObject -> intObject.doubleValue()); // ToDoubleFunction<? super T> mapper

        // IntStream к др. типам
        intStream = IntStream.of(1,2,3,4,5);
        IntStream intStream2 = intStream.map(i -> i + 1); // IntUnaryOperator mapper
        stream = intStream.mapToObj((i) -> new Integer(i)); // IntFunction<? extends Integer> mapper
        longStream = intStream.mapToLong((i) -> i); // IntToLongFunction mapper
        doubleStream = intStream.mapToDouble((i) -> i + .1); // IntToDoubleFunction mapper

        // LongStream к др. типам
        longStream = LongStream.of(1,2,3,4,5);
        LongStream longStream2 = longStream.map((l) -> l + 32000); // LongUnaryOperator mapper
        Stream<Long> longStreamObj = longStream.mapToObj(l -> new Long(l)); // LongFunction<? extends Long> mapper
        intStream = longStream.mapToInt(l -> new Integer((int) l)); // LongToIntFunction mapper
        doubleStream = longStream.mapToDouble(l -> l + .2); // LongToDoubleFunction mapper

        // DoubleStream к др. типам
        doubleStream = DoubleStream.of(1.,2.,3.,4.,5.);
        DoubleStream doubleStream2 = doubleStream.map( d -> d + .3); // DoubleUnaryOperator mapper
        Stream<Double> doubleStreamObj = doubleStream.mapToObj(d -> new Double(d)); // DoubleFunction<? extends Double> mapper
        intStream = doubleStream.mapToInt(d -> (int) d); // DoubleToIntFunction mapper
        longStream = doubleStream.mapToLong(d -> (long) d); // DoubleToLongFunction mapper
        System.out.println("-----------------------------------");



        /// Примеры конвертирования стримов в другие типы метода as"Type"Stream ///
        doubleStream = intStream.asDoubleStream();
        longStream = intStream.asLongStream();

        doubleStream = longStream.asDoubleStream();
    }
}
