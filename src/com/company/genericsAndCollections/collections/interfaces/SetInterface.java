package com.company.genericsAndCollections.collections.interfaces;

import com.company.genericsAndCollections.collections.comparing.ComparableExample;
import com.company.genericsAndCollections.collections.comparing.ComparatorExample;

import java.util.*;

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


        // Примеры добавления объеектов в структуру требующую реализацию Comparable
        Set<ComparatorExample> treeSet1 = new TreeSet<>();
        // treeSet1.add(new ComparatorExample(1,2, "First")); // ClassCastException

        Set<ComparableExample> treeSet2 = new TreeSet<>();
        treeSet2.add(new ComparableExample(1,2, "First"));

        // Использование wildcard
        Set<? super Comparable> treeSet3 = new TreeSet<>();
        treeSet3.add(new ComparableExample(1,2, "First"));
        //treeSet3.add(new ComparatorExample(1,2, "First")); // не компилится

        Set<ComparatorExample> treeSet4 = new TreeSet<>(new Comparator<ComparatorExample>() {
            @Override
            public int compare(ComparatorExample o1, ComparatorExample o2) {
                return o1.getWeight() - o2.getWeight();
            }
        }) ;
        treeSet4.add(new ComparatorExample(1,2, "First"));

    }
}
