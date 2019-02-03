package com.company.functionalProgramming.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPipeline {

    public static void main(String[] args) {

        // Пример вывести 2 имени длинной = 4 из отсортированного списка.
        List<String> list = Arrays.asList("Anna", "Tobey", "Leroy", "Alex");
        Stream<String> stream1 = list.stream();
        stream1.filter(s -> s.length() == 4)
                .sorted()
                .limit(2).forEach(System.out::println);
        System.out.println("------------------------");
    }
}
