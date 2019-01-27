package com.company.genericsAndCollections.collections.interfaces;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueInterface {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        Deque<String> stack = new ArrayDeque<>();
        // основные методы интерфейса Queue, которых нет в Collection
        // queue
        System.out.println("queue.add(\"Str1\"): " + queue.add("Str1")); // return boolean
        System.out.println("queue.add(\"Str2\"): " + queue.add("Str2")); // return boolean
        System.out.println("queue.add(\"Str3\"): " + queue.add("Str3")); // return boolean
        System.out.println("");
        System.out.println("queue.element(): " + queue.element()); // NoSuchElementException, если пусто
        System.out.println("queue.offer(\"Str4\"): " + queue.offer("Str4")); // return boolean
        System.out.println("queue.remove(): " + queue.remove()); // NoSuchElementException, если пусто
        System.out.println("queue.poll(): " + queue.poll()); // null, если пусто
        System.out.println("queue.peek(): " + queue.peek()); // null, если пусто
        System.out.println("----------------");
        // stack
        stack.push("Str1"); // void
        stack.push("Str2"); // void
        stack.push("Str3"); // void
        stack.push("Str4"); // void
        System.out.println("");
        System.out.println("stack.pop(): " + stack.pop());// NoSuchElementException, если пусто
        System.out.println("stack.pop(): " + stack.pop());// NoSuchElementException, если пусто
        System.out.println("stack.pop(): " + stack.pop());// NoSuchElementException, если пусто
        System.out.println("stack.pop(): " + stack.pop());// NoSuchElementException, если пусто
        //System.out.println("stack.pop(): " + stack.pop());// NoSuchElementException, если пусто
    }
}
