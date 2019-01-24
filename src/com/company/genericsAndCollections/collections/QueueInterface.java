package com.company.genericsAndCollections.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueInterface {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        Queue<String> stack = new ArrayDeque<>();
        // основные методы интерфейса Queue, которых нет в Collection
        // queue
        System.out.println("queue.add(\"Str1\"): " + queue.add("Str1"));
        System.out.println("queue.add(\"Str2\"): " + queue.add("Str2"));
        System.out.println("queue.add(\"Str3\"): " + queue.add("Str3"));
        System.out.println("");
        System.out.println("queue.element(): " + queue.element());
        System.out.println("queue.offer(\"Str4\"): " + queue.offer("Str4"));

    }
}
