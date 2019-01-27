package com.company.genericsAndCollections.collections.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample{

    private int age;
    private int weight;
    private String name;

    public ComparatorExample(int age, int weight, String name) {
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[ " +
                this.name + ", " +
                this.age + ", " +
                this.weight +" ] \n";
    }

    public int compareTo(ComparatorExample e) {
        return this.weight - e.weight;
    }

    public static void main(String[] args) {

        Comparator<ComparatorExample> comparator1 = new Comparator<ComparatorExample>() {
            @Override
            public int compare(ComparatorExample o1, ComparatorExample o2) {
                return o1.age - o2.age;
            }
        };

        Comparator<ComparatorExample> comparator2 = (o1, o2) -> o1.weight - o2.weight;

        List<ComparatorExample> list = new ArrayList<>();
        list.add(new ComparatorExample(1,2, "First"));
        list.add(new ComparatorExample(3,1, "Second"));
        list.add(new ComparatorExample(10,32, "Third"));
        list.add(new ComparatorExample(9,24, "Forth"));
        list.add(new ComparatorExample(90,254, "Fifth"));

        System.out.println("by age");
        Collections.sort(list, comparator1);
        System.out.println(list);

        System.out.println("by weight:");
        Collections.sort(list, comparator2);
        System.out.println(list);



        System.out.println("----------------");
        System.out.println("Статические методы компаратора");

        //Comparator<ComparatorExample> naturalComparator = Comparator.naturalOrder(); // с помощью Comparable
        //Comparator<ComparatorExample> reverseComparator = Comparator.reverseOrder(); // с помощью Comparable
        Comparator<ComparatorExample> comp = Comparator.comparing(s -> s.getWeight());


        // сравнение с помощью нескольких полей одновременно(если по первому не удалось определить, то второй)
        Comparator<ComparatorExample> multiComparator = Comparator.comparing(e -> e.getAge());
        multiComparator.thenComparing(e -> e.getWeight());
        multiComparator.reversed();

    }

}
