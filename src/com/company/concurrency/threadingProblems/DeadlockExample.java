package com.company.concurrency.threadingProblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockExample {

    private static class Food{}
    private static class Drink{}

    public static void drinkAndEat(Food food, Drink drink) {
        synchronized (drink) {
            System.out.println("Got drink");
            move();
            synchronized (food) {
                System.out.println("Got food");
            }
        }
    }

    public static void eatAndDrink(Food food, Drink drink) {
        synchronized (food) {
            System.out.println("Got food");
            move();
            synchronized (drink) {
                System.out.println("Got drink");
            }
        }
    }

    public static void move() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Food food = new Food();
        Drink drink = new Drink();
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();
            service.submit(() -> eatAndDrink(food, drink));
            service.submit(() -> drinkAndEat(food, drink));
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
