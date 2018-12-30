package com.company.advancedClassDesign.nestedClasses.anonymousClasses;

public class Main {

    public static String name = "Main";
    public int age = 22;

    SimpleInterface si2 = new SimpleInterface() {
        @Override
        public void run() {
            System.out.println("run implementation");
        }
    };

    public static void main(String[] args) {

        // Пример анонимного класса наследующего не абстрактный класс
        SimpleClass sc1 = new SimpleClass(){
            @Override
            public void printName() {
                System.out.println(name);
                System.out.println("overriden method");
                super.printName();
            }
        };
        sc1.printName();
        System.out.println("=============================");

        // Пример анонимного класса предоставляющего реализацию интерфейсу
        SimpleInterface si1 = new SimpleInterface() {
            @Override
            public void run() {
                System.out.println(name);
                System.out.println("run implementation");
            }
        };
        si1.run();
        System.out.println("=============================");

        // Пример анонимного класса наследующего абстрактный класс (предоставляет реализацию)
        SimpleAbstractClass sac1 = new SimpleAbstractClass() {
            @Override
            public void act() {
                System.out.println(name);
                System.out.println("action");
            }
        };
        sac1.act();
        System.out.println("=============================");

        // Передача реализации анонимного класса в качестве аргумента в метод
        example(new SimpleInterface() {
            @Override
            public void run() {
                System.out.println(name);
                System.out.println("realization in method argument");
            }
        });

    }

    public static void example(SimpleInterface si) {
        si.run();
    }

    public void example2(SimpleInterface si) {
        si.run();
    }

    // Доступ к переменным в анонимном классе такой же,
    // как и в локальном классе
    public void notStaticMethod() {
        int weight = 23;
        new Main().example2(new SimpleInterface() {
            @Override
            public void run() {
                System.out.println(age);
                System.out.println(weight);
                System.out.println("realization in method argument");
            }
        });
    }
}
