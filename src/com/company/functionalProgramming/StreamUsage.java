package com.company.functionalProgramming;

        import java.util.*;
        import java.util.function.Predicate;
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
        System.out.println("----------------------");

        // findFirst(), findAny()
        Stream<Integer> varargsStream1 = Stream.of(0,12,3,4,5); // varargs
        Stream<String> varargsStream2 = Stream.of("A","B","C"); // varargs
        unOperatorStream = Stream.iterate(1, n -> n+2);
        emptyStream = Stream.empty();
        System.out.println("varargsStream1.findFirst().get(): " + varargsStream1.findFirst().get());
        System.out.println("varargsStream2.findAny().get(): " + varargsStream2.findAny().get());
        System.out.println("unOperatorStream.findAny().get(): " + unOperatorStream.findAny().get());
        System.out.println("emptyStream.findAny().isPresent(): " + emptyStream.findAny().isPresent());
        System.out.println("----------------------");

        // allMatch(), anyMatch(), noneMatch()
        supplierStream = Stream.generate(() -> 1.);
        unOperatorStream = Stream.iterate(1, n -> 1);
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        varargsStream1 = Stream.of(0,12,3,4,5); // varargs
        Predicate<Integer> predicate = i -> i >= 0;
        //System.out.println("supplierStream.allMatch((d) -> d == 1): " + supplierStream.allMatch((d) -> d == 1)); // висит
        System.out.println("unOperatorStream.anyMatch(predicate): " + unOperatorStream.anyMatch(predicate)); // прерывает бесконечный стрим
        System.out.println("varargsStream.anyMatch(predicate): " + varargsStream.anyMatch(predicate));
        System.out.println("varargsStream1.noneMatch(predicate): " + varargsStream1.noneMatch(predicate));
        System.out.println("----------------------");

        // forEach()
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        System.out.println("varargsStream.forEach((e) -> System.out.println(e)): ");
        varargsStream.forEach((e) -> System.out.print(e + 5 + ", "));
        System.out.println();
        System.out.println("----------------------");

        // reduce()
    }
}
