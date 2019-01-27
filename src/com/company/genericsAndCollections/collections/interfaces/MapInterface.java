package com.company.genericsAndCollections.collections.interfaces;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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


        /// Java 8 Map Api ///
        map.putIfAbsent("Tenth", 100);
        System.out.println(map);
    }
}
