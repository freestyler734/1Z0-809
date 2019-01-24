package com.company.genericsAndCollections.collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // Set не добавляет новых осн. методов, указанных в интерфейсе Collection,
        // но реализация TreeSet реализует интерфейс NavigableSet, поэтому рассмотрим его основные интерфейсы
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(1);
        navigableSet.add(2);
        navigableSet.add(3);
        navigableSet.add(4);
        navigableSet.add(5);

        System.out.println("navigableSet.lower(3): " + navigableSet.lower(3)); // <
        System.out.println("navigableSet.floor(3): " + navigableSet.floor(3)); // <=
        System.out.println();
        System.out.println("navigableSet.higher(3): " + navigableSet.higher(3)); // >
        System.out.println("navigableSet.ceiling(3): " + navigableSet.ceiling(3)); // >=
    }
}
