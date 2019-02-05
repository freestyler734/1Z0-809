package com.company.functionalProgramming.stream;

import java.time.LocalDate;
import java.util.IntSummaryStatistics;
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
        System.out.println("\n-----------------------------------");


        /// Примеры конвертирования стримов в другие типы с помощью map ///
        // Stream к др. типам
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream3 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream4 = Stream.of(1,2,3,4,5);

        Stream<Integer> streamStream = stream.map(intObject -> intObject + 1); // Function<? super T, ? extends R> mapper
        intStream = stream2.mapToInt(intObject -> intObject.intValue()); // ToIntFunction<? super T> mapper
        longStream = stream3.mapToLong(intObject -> intObject.longValue()); // ToLongFunction<? super T> mapper
        doubleStream = stream4.mapToDouble(intObject -> intObject.doubleValue()); // ToDoubleFunction<? super T> mapper

        // IntStream к др. типам
        intStream = IntStream.of(1,2,3,4,5);
        IntStream intStream2 = IntStream.of(1,2,3,4,5);
        IntStream intStream3 = IntStream.of(1,2,3,4,5);
        IntStream intStream4 = IntStream.of(1,2,3,4,5);

        IntStream intStreamIntStream = intStream.map(i -> i + 1); // IntUnaryOperator mapper
        stream = intStream2.mapToObj((i) -> new Integer(i)); // IntFunction<? extends Integer> mapper
        longStream = intStream3.mapToLong((i) -> i); // IntToLongFunction mapper
        doubleStream = intStream4.mapToDouble((i) -> i + .1); // IntToDoubleFunction mapper

        // LongStream к др. типам
        longStream = LongStream.of(1,2,3,4,5);
        LongStream longStream2 = LongStream.of(1,2,3,4,5);
        LongStream longStream3 = LongStream.of(1,2,3,4,5);
        LongStream longStream4 = LongStream.of(1,2,3,4,5);
        LongStream longStreamLongStream = longStream.map((l) -> l + 32000); // LongUnaryOperator mapper
        Stream<Long> longStreamObj = longStream2.mapToObj(l -> new Long(l)); // LongFunction<? extends Long> mapper
        intStream = longStream3.mapToInt(l -> new Integer((int) l)); // LongToIntFunction mapper
        doubleStream = longStream4.mapToDouble(l -> l + .2); // LongToDoubleFunction mapper

        // DoubleStream к др. типам
        doubleStream = DoubleStream.of(1.,2.,3.,4.,5.);
        DoubleStream doubleStream2 = DoubleStream.of(1.,2.,3.,4.,5.);
        DoubleStream doubleStream3 = DoubleStream.of(1.,2.,3.,4.,5.);
        DoubleStream doubleStream4 = DoubleStream.of(1.,2.,3.,4.,5.);
        DoubleStream doubleStreamDoubleStream = doubleStream.map( d -> d + .3); // DoubleUnaryOperator mapper
        Stream<Double> doubleStreamObj = doubleStream2.mapToObj(d -> new Double(d)); // DoubleFunction<? extends Double> mapper
        intStream = doubleStream3.mapToInt(d -> (int) d); // DoubleToIntFunction mapper
        longStream = doubleStream4.mapToLong(d -> (long) d); // DoubleToLongFunction mapper
        System.out.println("-----------------------------------");

        /// Примеры конвертирования стримов в другие типы метода as"Type"Stream ///
        doubleStream = IntStream.range(1 ,11).asDoubleStream();
        
        longStream = IntStream.range(1 ,11).asLongStream();
        doubleStream = longStream.asDoubleStream();


        /// SummarizingStatistics ///
        intStream = IntStream.rangeClosed(1, 10);
        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics(); // терминальная операция
        System.out.println("intSummaryStatistics.getMin(): " + intSummaryStatistics.getMin());
        System.out.println("intSummaryStatistics.getMax(): " + intSummaryStatistics.getMax());
        System.out.println("intSummaryStatistics.getAverage(): " + intSummaryStatistics.getAverage());
        System.out.println("intSummaryStatistics.getSum(): " + intSummaryStatistics.getSum());
        System.out.println("intSummaryStatistics.getCount(): " + intSummaryStatistics.getCount());
        // intStream.forEach(i -> System.out.print(i + ", ")); не скомпилится

        intStream =  IntStream.range(1, 11);
        intStream.forEach(i -> System.out.print(i + ", "));
        // intStream.summaryStatistics(); не скомпилится

    }
}
