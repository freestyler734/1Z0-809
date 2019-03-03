package com.company.concurrency.parallelStreams;


import java.util.ArrayList;
import java.util.List;

/*
    Демонстрация увеличения скорости обработки элементов стрима,
    с помощью паралелльного стрима.
 */
public class ParallelStreamPerfomanceImprovement {

    // Допустим что одна операция над элементов занимает 10 мсек.
    public static int operation(int i) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return i+1;
    }

    public static void processData(List<Integer> list) {
        list.stream().map(i -> operation(i)).count();
    }

    public static void processDataInParallel(List<Integer> list) {
        list.parallelStream().map(i -> operation(i)).count();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        processData(list);
        long time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Время исполнения в простом стриме: " + time);

        start = System.currentTimeMillis();
        processDataInParallel(list);
        time = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Время исполнения в параллельном стриме: " + time);


    }
}
