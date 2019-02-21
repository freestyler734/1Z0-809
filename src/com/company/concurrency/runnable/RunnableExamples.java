package com.company.concurrency.runnable;

public class RunnableExamples {

    // Примеры реализации интерфейса java.lang.Runnable, который представляет собой задачу,
    // выполняемую потоком

    // 1 способ. Реализовать метод
    // Преимущество - можно передать параметры
    static class Task1 implements Runnable {

        int i;

        Task1(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("task1");
        }
    }

    public static void main(String[] args) {

        // 1 способ. Реализовать метод
        Runnable task1 = new Task1(10);

        // 2 способ. Использовать лямбды
        Runnable task2 = () -> System.out.println("task2");
    }
}
