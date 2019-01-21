package com.company.designPatternsAndPrinciples.patterns.factory;

/**
 * Пример реализации фибрики
 */
public class ItemFactory {

    // запрещаем создание объекта
    private ItemFactory(){}

    // метод возвращает объекты разных типов,
    // в зависимости от входных параметров
    public static Item getItem(String name) {
        switch (name) {
            case "pen":
                return new Pen();
            case "notebook":
                return new Notebook();
            case "pencil":
                return new Pencil();
            case "table":
                return new Table();
            default:
                throw new IllegalArgumentException("There's no such objects");
        }
    }
}
