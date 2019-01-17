package com.company.designPatternsAndPrinciples.patterns.singleton;

/*
  Реализация синглтона
 */
public class Singleton {

    private String name;
    private int age;

    // Созданный экземпляр(можно создавать в статическом блоке инициализации)
    private static final Singleton instance = new Singleton();

    /*
     Скрываем конструктор и делаем класс фактически final
     */
    private Singleton() {
        name = "Singleton";
        age = 22;
    }

    public static Singleton getInstance(){
        return instance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // synchronized, т.к. синглтон может использоваться разными потоками
    public synchronized void addYear(int i) {

        if (i <= 0) {
            throw new IllegalArgumentException("Число д.б. больше нуля");
        }

        this.age += i;
    }
}
