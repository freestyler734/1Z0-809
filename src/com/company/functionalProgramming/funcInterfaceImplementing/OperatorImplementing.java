package com.company.functionalProgramming.funcInterfaceImplementing;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/*
    Примеры реализации функционального интерфейса UnaryOperator<T> и BinaryOperator<T>
 */
public class OperatorImplementing {

    public static void main(String[] args) {
        UnaryOperator<String> operator1 = String::toUpperCase;
        UnaryOperator<String> operator2 = s -> s.toUpperCase();
        System.out.println(operator1.apply("asd"));
        System.out.println(operator2.apply("asd"));
        System.out.println("--------------");

        BinaryOperator<String> binaryOperator1 = String::concat;
        BinaryOperator<String> binaryOperator2 = (s1, s2) -> s1.concat(s2);
        System.out.println(binaryOperator1.apply("123", "4567"));
        System.out.println(binaryOperator2.apply("1234", "567"));
        System.out.println("--------------");
    }
}
