package com.company.genericsAndCollections.collections.interfaces;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapInterface {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        // Осн. методы интерфейса Map:
        System.out.println("map.isEmpty(): " + map.isEmpty());
        System.out.println("map.size(): " + map.size());
        System.out.println("map.clear(): "); map.clear(); // void
        System.out.println("");
        System.out.println("map.put(\"First\", 1): " + map.put("First", 1)); // возвращает предыдущее значение при замене
        System.out.println("map.put(\"Second\", 2): " + map.put("Second", 2)); // возвращает предыдущее значение при замене
        System.out.println("map.put(\"Third\", 3): " + map.put("Third", 3)); // возвращает предыдущее значение при замене
        System.out.println("map.put(\"First\", 10): " + map.put("First", 10)); // возвращает предыдущее значение при замене
        System.out.println("");
        System.out.println("map.get(new String(\"Second\")): " + map.get(new String("Second"))); // использует equals. null, если пусто
        System.out.println("");
        System.out.println("map.remove(\"Third\"): " + map.remove("Third")); // null, если пусто
        System.out.println("");
        System.out.println("map.containsKey(\"Third\"): " + map.containsKey("Third")); // return boolean
        System.out.println("map.containsValue(10): " + map.containsValue(10)); // return boolean
        System.out.println("");
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();

        for (String key: map.keySet()) {
            System.out.print(map.get(key)+ " ");
        }
        System.out.println("");
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            entry.setValue(entry.getValue() * 10);
            System.out.println(entry.getKey()+": " + entry.getValue());
        }
        System.out.println("");
        for (String key: map.keySet()) {
            System.out.print(map.get(key)+ " ");
        }
        System.out.println("");

        /// Функциональные методы ///
        System.out.println(map);
        map.replaceAll((key, value) -> value * 2);
        System.out.println(map);

        System.out.println("");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("");


        /// Java 8 Map Api ///
        System.out.println(" map.putIfAbsent(\"Tenth\", 100): " +  map.putIfAbsent("Tenth", 100));
        System.out.println(" map.putIfAbsent(\"Tenth\", 100): " +  map.putIfAbsent("Tenth", 10));
        System.out.println(" map.putIfAbsent(\"Eleventh\", null): " +  map.putIfAbsent("Eleventh", null));
        System.out.println(map);
        System.out.println("");
        // Пример использования: V merge() - возвращает значение по ключу, которое осталось после изменений, либо новое значение
        BiFunction<Integer, Integer, Integer> mergeFunc = (v1, v2) -> v1 > v2 ? v1 : v2;
        BiFunction<Integer, Integer, Integer> mergeFuncNull = (v1, v2) -> null; // случай когда BiFunction возвращает null
        System.out.println("map.merge(\"Second\", 30, mergeFunc): "  + map.merge("Second", 30, mergeFunc)); // ключ есть - присваиваем значение по логике BiFunction
        System.out.println("map.merge(\"Second\", 50, mergeFunc): " + map.merge("Second", 50, mergeFunc)); // ключ есть - присваиваем значение по логике BiFunction
        System.out.println("map.merge(\"Third\", 1, mergeFunc): " + map.merge("Third", 1, mergeFunc)); // если ключ новый - добавляеется значение без применения BiFunction
        //System.out.println("map.merge(\"Forth\", null, mergeFunc): " + map.merge("Forth", null, mergeFunc)); // если ключ новый - и значение null - NullPointerException
        //System.out.println("map.merge(\"First\", null, mergeFunc): " + map.merge("First", null, mergeFunc)); // ключ есть - и значение null - NullPointerException
        System.out.println("map.put(\"Forth\", null): " + map.put("Forth", null));
        System.out.println("map.merge(\"Forth\", 111, mergeFunc): " +  map.merge("Forth", 111, mergeFunc)); // если старое значение null, то значение просто заменяется и BiFunction не вызывается
        System.out.println(map.merge("First", 222, mergeFuncNull)); // если BiFunction вернула null, то если ключ существовал - он удалаяется (возвращает значение новое)
        System.out.println(map.merge("Fifth", 222, mergeFuncNull)); // если BiFunction вернула null, если ключ новый - добавляеется значение без применения BiFunction
        System.out.println(map);
        System.out.println("");
        // Примеры использования computeIfPresent/computeIfAbscent - возвращ-т новое значение, иначе null
        BiFunction<String, Integer, Integer> presentComputer = (k, v) -> v + 1;
        System.out.println("map.computeIfPresent(\"First\", presentComputer): " + map.computeIfPresent("First", presentComputer));
        System.out.println("map.computeIfPresent(\"Second\", presentComputer): " + map.computeIfPresent("Second", presentComputer));
        System.out.println("map.computeIfPresent(\"Third\", (k,v) -> null): " + map.computeIfPresent("Third", (k,v) -> null)); // ключ удаляется из map
        System.out.println(map);
        System.out.println("");
        Function<String, Integer> abscentComputer = (k) -> 12;
        System.out.println("map.computeIfAbsent(\"First\", abscentComputer): " + map.computeIfAbsent("First", abscentComputer));
        System.out.println("map.computeIfAbsent(\"Third\", abscentComputer): " + map.computeIfAbsent("Third", abscentComputer));
        System.out.println("map.put(\"Seventh\", null): " + map.put("Seventh", null));
        System.out.println("map.computeIfAbsent(\"Seventh\", abscentComputer): " + map.computeIfAbsent("Seventh", abscentComputer));
        System.out.println("map.computeIfAbsent(\"Eighth\", (k) -> null): " + map.computeIfAbsent("Eighth", (k) -> null)); // ключ не добавится с null
        System.out.println(map);
    }
}
