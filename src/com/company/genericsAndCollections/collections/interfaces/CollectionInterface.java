package com.company.genericsAndCollections.collections.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionInterface {

    public static void main(String[] args) {
        // Примеры использования и работы осн. методов интерфейса Collection
        System.out.println("Основные методы:");
        Collection<String> collection = new HashSet<>();
        System.out.println("collection.size(): " + collection.size());
        System.out.println("collection.isEmpty(): " + collection.isEmpty());
        System.out.println("");
        System.out.println("collection.add(\"Str1\"): " + collection.add("Str1"));
        System.out.println("collection.add(\"Str2\"): " + collection.add("Str2"));
        System.out.println("collection.add(\"Str3\"): " + collection.add("Str3"));
        System.out.println("");
        System.out.println("collection.remove(\"Str1\"): " + collection.remove("Str1"));
        System.out.println("collection.remove(\"Str10\"): " + collection.remove("Str10"));
        System.out.println("");
        System.out.println("collection.clear();"); collection.clear();
        System.out.println("");
        System.out.println("collection.add(\"Str4\"): " + collection.add("Str4"));
        System.out.println("collection.add(\"Str5\"): " + collection.add("Str5"));
        System.out.println("collection.add(\"Str6\"): " + collection.add("Str6"));
        System.out.println("collection.add(\"Str6\"): " + collection.add("Str7"));
        System.out.println("");
        System.out.println("collection.contains(\"Str1\"): " + collection.contains("Str1"));
        System.out.println("collection.contains(\"Str5\"): " + collection.contains("Str5"));
        System.out.println("");
        System.out.println("----------------------------");
        // Реализации методов интерфеса построены так,
        // что если операция завершилась успешно, то возвращаем true, иначе false.
        // Никакие исключения не выбрасываются при неудачном завершении ситуаций(кроме JVM).
        //
        // Также в интерфейсе нет методов типа get() элемент.


        /// Функциональные методы ///
        System.out.println("Функцинальные методы:");
        System.out.println(collection);
        System.out.println("collection.removeIf(s -> s.contains(\"4\")): " + collection.removeIf(s -> s.contains("4")));
        System.out.println(collection);
        System.out.println("");

        collection.forEach(e -> System.out.print(e + ", "));
        System.out.println("");
        collection.forEach(System.out::print);


    }
}
