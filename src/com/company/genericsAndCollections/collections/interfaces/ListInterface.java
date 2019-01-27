package com.company.genericsAndCollections.collections.interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListInterface {

    public static void main(String[] args) {
        // Дополнительные методы, добавленные в List интерфейс, помимо методов в Collection
        List<String> list = new ArrayList<>();
        // вставка элемента по указанному индексу. не возвращает результат(void)
        // работает в рамках текущей длинны, если индекс > то исключение
        list.add(0, "Str1");
        list.add(0, "Str1");
        list.add(1, "Str2");
        list.add(0, "Str3");

        System.out.println("list.get(0): " + list.get(0));
        // System.out.println("list.get(0): " + list.get(3)); // исключение IndexOutOfBoundsException
        System.out.println("");
        System.out.println("list.indexOf(\"Str1\"): " + list.indexOf("Str1"));
        System.out.println("list.indexOf(\"Str4\"): " + list.indexOf("Str4"));
        System.out.println("list.lastIndexOf(\"Str1\"): " + list.lastIndexOf("Str1"));
        System.out.println("list.lastIndexOf(\"Str4\"): " + list.lastIndexOf("Str4"));
        System.out.println("");
        System.out.println("list.remove(0): "+ list.remove(0)); // возвращает удаленный элемент
        System.out.println("list.set(0, \"0\"): " + list.set(0, "0")); // возвращает старый элемент по индексу
        System.out.println("");
        // List добавляет в основном методы для работы с коллекциями по индексу.
        // При удалении/замене элементов методы в List возвращают старый элемент,
        // также в реализациях интерфейса есть аналоги этих методов с void.

        ///

        // Пример использования итератора
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println("\n");

        /// Функциональные методы ///
        System.out.println(list);
        System.out.print("list.replaceAll(str -> str + \"as\"): \n");
        list.replaceAll(str -> str + "as");
        System.out.println(list);

    }
}
