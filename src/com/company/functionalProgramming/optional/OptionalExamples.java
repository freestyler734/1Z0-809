package com.company.functionalProgramming.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.of("asd");
        Optional<String> optional3 = Optional.ofNullable(null);
        Optional<String> optional4 = Optional.of("asd");

        System.out.println("optional1.equals(optional3): " + optional1.equals(optional3));
        System.out.println("optional2.equals(optional3): " + optional2.equals(optional3));
        System.out.println("optional2.equals(optional4): " + optional2.equals(optional4));
        System.out.println("optional1 == optional3: " + (optional1 == optional3));
        System.out.println("optional2 == optional4: " + (optional2 == optional4));
        System.out.println("--------------------");

        //System.out.println("optional1.get(): " + optional1.get()); // NoSuchElementException
        System.out.println("optional2.get(): " + optional2.get());
        //System.out.println("optional2.get(): " + optional3.get()); // NoSuchElementException
        System.out.println("--------------------");

        System.out.println("optional1.isPresent(): " + optional1.isPresent());
        System.out.println("optional2.isPresent(): " + optional2.isPresent());
        System.out.println("optional3.isPresent(): " + optional3.isPresent());
        System.out.println("--------------------");

        optional1.ifPresent(System.out::println); // Consumer
        optional2.ifPresent(System.out::println); // Consumer
        System.out.println("--------------------");

        System.out.println("optional1.orElse(\"empty\"): " + optional1.orElse("empty")); // возвр-т параметр, если значения нет
        System.out.println("optional2.orElse(\"empty\"): " + optional2.orElse("empty")); // возвр-т параметр, если значения нет
        System.out.println("--------------------");

        System.out.println("optional1.orElseGet(() -> \"empty\"): " + optional1.orElseGet(() -> "empty")); // Supplier
        System.out.println("optional2.orElseGet(() -> \"empty\"): " + optional2.orElseGet(() -> "empty")); // Supplier
        System.out.println("--------------------");

        // System.out.println(optional1.orElseThrow(() -> new NoSuchElementException("Custom Exception"))); // Исключение, т.к. пустой
        System.out.println(optional2.orElseThrow(() -> new NoSuchElementException("Custom Exception"))); // значение есть, поэтому нет исключения
    }
}
