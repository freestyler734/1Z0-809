package com.company.functionalProgramming.funcInterfaceImplementing;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
    Примеры реализации функционального интерфейса Predicate<T> и BiPredicate<T, U>
 */
public class PredicateImplementing {

    public static void main(String[] args) {
        Predicate<String> predicate1 = String::isEmpty;
        Predicate<String> predicate2 = s -> s.isEmpty();
        System.out.println(predicate1.test(""));
        System.out.println(predicate2.test(""));
        System.out.println("--------------");

        BiPredicate<String, String> biPredicate1 = String::startsWith;
        BiPredicate<String, String> biPredicate2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(biPredicate1.test("abc", "a"));
        System.out.println(biPredicate2.test("abc", "a"));
    }
}
