package com.company.designPatternsAndPrinciples.patterns.singleton;

/*
    Пример реализции паттерна синглтон с ленивой инициализацией
    (инициализацией при первом обращении)
 */
public class LazyInstantiationSingleton {

    private volatile static LazyInstantiationSingleton instance;

    private LazyInstantiationSingleton(){};

    // synchronized - два потока не смогут создать одновременно 2 объекта.
    public static LazyInstantiationSingleton getInstance() {

        // Ленивая инициализация
        if (instance == null) {
            synchronized (LazyInstantiationSingleton.class) {
                instance = new LazyInstantiationSingleton();
            }
        }

        return instance;
    }
}
