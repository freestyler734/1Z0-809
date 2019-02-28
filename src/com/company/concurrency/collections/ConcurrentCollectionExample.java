package com.company.concurrency.collections;

import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentCollectionExample {

    Map<String, String> map = new ConcurrentHashMap<>();
    Deque deque = new ConcurrentLinkedDeque();

    public static void main(String[] args) {
        //Collections.synchronizedCollection();
    }
}
