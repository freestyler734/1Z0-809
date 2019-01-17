package com.company.designPatternsAndPrinciples.patterns.immutableObject;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    // поля private и final
    private final String name;
    private final int age;
    private final List<String> toys;

    public Pet (String name, int age, List<String> toys) {
        // поля инициализируется только в конструкторе
        this.name = name;
        this.age = age;

        if (toys == null) {
            throw new RuntimeException("Списка игрушек не существует");
        }
        // создаем новый объект, а не присваиваем ссылку,
        // иначе поле будет доступен извне
        this.toys = new ArrayList<>(toys);
    }

    // Все методы - final

    //  String - неизменяемый
    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    // Даем доступ к колекции но не прямой
    public final String getToy(int i) {
        if (i < 0 || i >= toys.size()) {
            throw new IllegalArgumentException("Неверный индекс");
        }

        return toys.get(i);
    }

    public final Pet addYear(int years) {
        // Создаем новую коллекцию
        List<String> toys = new ArrayList<>(this.toys);
        return new Pet(this.name, this.age + years, toys);
    }


    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", toys=" + toys.toString() +
                '}';
    }
}
