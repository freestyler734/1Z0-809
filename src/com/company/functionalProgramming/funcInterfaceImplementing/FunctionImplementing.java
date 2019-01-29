package com.company.functionalProgramming.funcInterfaceImplementing;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
    Примеры реализации функционального интерфейса Function<T, R> и BiFunction<T, U, R>
 */
public class FunctionImplementing {

    public static void main(String[] args) {
        // еще один пример использования типа ссылок методов,
        // где объект неизвестен до времени исполнения
        Function<String, Integer> function1 = String::length;
        Function<String, Integer> function2 = s -> s.length();
        System.out.println(function1.apply("fdasf"));
        System.out.println(function2.apply("fdasf"));
        System.out.println("--------------");

        BiFunction<String, String, String> biFunction1 = String::concat;
        BiFunction<String, String, String> biFunction2 = (s1, s2) -> s1.concat(s2);
        System.out.println(biFunction1.apply("qwe", "rty"));
        System.out.println(biFunction2.apply("qwe", "rty"));
        System.out.println("--------------");
    }
}
