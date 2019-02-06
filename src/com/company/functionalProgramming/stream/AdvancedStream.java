package com.company.functionalProgramming.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class AdvancedStream {

    public static void main(String[] args) {
        // Стрим не выполняется до вызова терминальных операций
        List<String> list = new ArrayList<>();
        list.add("s1");
        list.add("s2");
        Stream<String> stream = list.stream();
        list.add("s4");
        System.out.println("stream.count(): " + stream.count());

        // Optional Chaining
        Optional<String> optional = Optional.of("123");
        int result = optional.map(s -> Integer.parseInt(s))
                .filter(i -> i < 100)
                .orElse(-1);
        System.out.println(result);
    }
}
