package com.company.functionalProgramming;

        import java.util.*;
        import java.util.stream.Stream;

public class StreamUsage {

    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(21);
        list.add(1);
        list.add(5);
        list.add(89);

        Map<String, Integer> map = new HashMap<>();


        /// Примеры создания Стримов ///
        /// Стримы пересоздаются, т.к. их нельзя использовать повторно(после терминальных операций) ///
        // Конечные
        Stream<Integer> emptyStream = Stream.empty();
        Stream<Integer> singleElStream = Stream.of(2); // один элемент (T t)
        Stream<Integer> varargsStream = Stream.of(0,12,3,4,5); // varargs
        Stream<Integer> collectionStream = list.stream();
        // Бесконечные
        Stream<Double> supplierStream = Stream.generate(Math::random);
        Stream<Integer> unOperatorStream = Stream.iterate(1, n -> n+2);

        /// Основные терминальные операции ///
        // count()
        System.out.println("emptyStream.count()): " + emptyStream.count());
        System.out.println("varargsStream.count(): " + varargsStream.count());
        // System.out.println("supplierStream.count(): " + supplierStream.count()); // висит т.к. бесконечный стрим
        System.out.println("----------------------");

        // min(), max()
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        unOperatorStream = Stream.iterate(1, n -> n+2);
        emptyStream = Stream.empty();
        System.out.println("varargsStream.max((i1, i2) -> i1 - i2).get(): " + varargsStream.max((i1, i2) -> i1 - i2).get());
        // System.out.println("unOperatorStream.min((i1, i2) -> i1 - i2).get(): " + unOperatorStream.min((i1, i2) -> i1 - i2).get()); // висит т.к. бесконечный стрим
        System.out.println("emptyStream.min((i1, i2) -> i1 - i2).isPresent(): " + emptyStream.min((i1, i2) -> i1 - i2).isPresent());

        // findFirst(), findAny()

    }
}
