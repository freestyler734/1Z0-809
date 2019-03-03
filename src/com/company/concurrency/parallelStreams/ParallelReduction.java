package com.company.concurrency.parallelStreams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelReduction {

    /*
        Примеры работы reduction методов для паралелльных стримов
     */
    public static void main(String[] args) {
        Stream<Integer> parallelStream1 = Arrays.asList(1,2,3,4,5).parallelStream();
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5).parallelStream();
        Stream<Integer> unorderedParallelStream = Arrays.asList(1,2,3,4,5).parallelStream().unordered();

        System.out.println("parallelStream1.findAny().get(): " + parallelStream1.findAny().get());
        System.out.println("parallelStream2.skip(2).findFirst().get(): " + parallelStream2.skip(2).findFirst().get());
        System.out.println("unorderedParallelStream.skip(3).findFirst().get(): " + unorderedParallelStream.skip(3).findFirst().get());

        System.out.println("\n----------------------------------\n");

        /// reduce() - меотод в паралелльном окружении ///
        // Пример правильного вызова reduce для паралелльного стрима.
        Stream<Character> parallelStream3 = Arrays.asList('H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!').parallelStream();
        String result1 = parallelStream3.reduce("",
                (s1, c) -> s1 + c,
                (s2, s3) -> s2 + s3
        );
        System.out.println("Правильный пример вызова reduce в паралелльном стриме: " + result1);

        // Нарушение правила 1. combiner.apply(identity, u) равно u (т.е. изначально identity д.б. пустым)
        Stream<Character> parallelStream4 = Arrays.asList('H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!').parallelStream();
        String result2 = parallelStream4.reduce("Start: ",
                (s1, c) -> s1 + c,
                (s2, s3) -> s2 + s3
        );
        System.out.println("Нарушение правила 1 для reduce в паралелльном стриме: " + result2);

        // Нарушение правила 2. accumulator.apply(a, accumulator.apply(b, c)) равно accumulator.apply(accumulator.apply(a, b), c).
        Stream<Integer> parallelStream5 = Arrays.asList(1,2,3,4,5).stream();
        int result3 = parallelStream5.reduce(0, (a, b) -> a - b);
        System.out.println("Нарушение правила 2 для reduce в паралелльном стриме: " + result3);

        // Нарушение правила 3. combiner.apply(u, accumulator.apply(identity, t)) равно accumulator.apply(u, t)
        Stream<Character> parallelStream6 = Arrays.asList('H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!').parallelStream();
        String result4 = parallelStream6.reduce( "",
                (s1, c) -> s1 + c,
                (s2, s3) -> s3 + s2
        );
        System.out.println("Нарушение правила 3 для reduce в паралелльном стриме: " + result4);

    }
}
