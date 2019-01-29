package com.company.functionalProgramming.funcInterfaceImplementing;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
    Примеры реализации функционального интерфейса Consumer<T> и BiConsumer<T, U>
 */
public class ConsumerImplementing {

    public static void main(String[] args) {
        Consumer<String> consumer1 = System.out::println;
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer1.accept("qwe");
        consumer2.accept("rty");
        System.out.println("--------------");

        BiConsumer<String, Integer> biConsumer1 = (s, i) -> System.out.println(s + i);
        BiConsumer<Integer, Integer> biConsumer2 = (i1, i2) -> System.out.println(i1 + i2);
        biConsumer1.accept("qwe", 213);
        biConsumer2.accept(234, 213);
    }
}
