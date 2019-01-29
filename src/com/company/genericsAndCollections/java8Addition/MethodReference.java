package com.company.genericsAndCollections.java8Addition;

import com.company.genericsAndCollections.common.Duck;
import com.company.genericsAndCollections.common.DuckHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface DuckSupplier {
    Duck get(String name, int age, int weight);
}

/*
    Примеры использования ссылок на метод
 */
public class MethodReference {

    public static void main(String[] args) {
        // Пример использования компаратора с помощью лямбд
        Comparator<Duck> comparable1 = (Duck d1, Duck d2) -> DuckHelper.compareByAge(d1, d2);

        // Пример использования компаратора с помощью ссылки на метод
        Comparator<Duck> comparable2 = DuckHelper::compareByAge;


        /// Примеры использования ссылок на переменные разных типов ///
        /// и лямбды выражения, которыми их можно заменить          ///

        // Статический метод
        Consumer<List<String>> consumer1 = Collections::sort;
        Consumer<List<String>> consumer2 = (List<String> list) -> Collections.sort(list);
        List<String> list = new ArrayList<>();
        list.add("r1");
        list.add("21");
        list.add("23");
        list.add("4xzc");
        list.add("zxc5");
        System.out.println("До cортировки: " + list);
        consumer1.accept(list);
        // consumer2.accept(list);
        System.out.println("После сортировки: " + list);
        System.out.println("------------------");

        // Метод конкретного экземпляра
        String s = "abc";
        Predicate<String> predicate1 = s::startsWith;
        Predicate<String> predicate2 = str -> s.startsWith(str);
        System.out.println(predicate1.test("a"));
        System.out.println(predicate2.test("ab"));
        System.out.println("------------------");

        // Метод экземпляра не известного до времени исполнения
        Predicate<String> predicate3 = String::isEmpty; // экземпляр объекта неизвестен(работает с методами без параметров)
        Predicate<String> predicate4 = str -> str.isEmpty();
        System.out.println(predicate3.test("as"));
        System.out.println(predicate4.test("as"));
        System.out.println("------------------");

        // Конструкторы
        Supplier<String> supplier1 = String::new;
        Supplier<String> supplier2 = () -> "";
        DuckSupplier duckSupplier = Duck::new; // пример использования своего интерфейса для конструктора с параметрами
        System.out.println(supplier1.get().length());
        System.out.println(supplier2.get().length());
        duckSupplier.get("1",1,1);
        System.out.println("------------------");


    }
}
