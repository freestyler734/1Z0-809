package com.company.functionalProgramming;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.of(null);
        Optional<String> optional3 = Optional.ofNullable(null);

    }
}
