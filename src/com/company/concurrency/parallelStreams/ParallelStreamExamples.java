package com.company.concurrency.parallelStreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStreamExamples {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        Stream<Integer> parallelStream1 = Arrays.asList(1,2,3,4,5).parallelStream();
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5).parallelStream();
        System.out.println("Кол-во доступных ядер процессора: " + Runtime.getRuntime().availableProcessors());
        System.out.println("");

        System.out.print("Работа обычного стрима forEach: ");
        stream.forEach( (i) -> System.out.print(i + ", "));

        System.out.println("\n---------------------");

        System.out.print("Работа параллельного стрима forEach: ");
        parallelStream1.forEach( (i) -> System.out.print(i + ", "));
        System.out.println("");
        System.out.print("Работа параллельного стрима forEachOrdered: ");
        parallelStream2.forEachOrdered( (i) -> System.out.print(i + ", "));

    }
}
