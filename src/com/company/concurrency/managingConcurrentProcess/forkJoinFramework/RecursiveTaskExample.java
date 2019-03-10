package com.company.concurrency.managingConcurrentProcess.forkJoinFramework;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample {

    private static class WeightAnimalTask extends RecursiveTask<Double> {

        private int start;
        private int end;
        private double[] weights;

        public WeightAnimalTask(int start, int end, double[] weights) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        protected Double compute() {
            if (end - start <= 3) {
                double tripleSum = 0;
                for (int i = start; i < end; i++) {
                    weights[i] = new Random().nextInt(100);
                    System.out.println("Animal weighted: " + i);
                    tripleSum += weights[i];
                }
                return tripleSum;
            } else {
                int middle = start + ((end - start) / 2);
                System.out.println("[start=" + start + ", middle=" + middle + ", end=" + end + "]");
                // Создаем новую задачу
                RecursiveTask<Double> otherTask1 = new WeightAnimalTask(start, middle, weights);
                RecursiveTask<Double> otherTask2 = new WeightAnimalTask(middle, end, weights);
                otherTask1.fork(); // говорим что задача должна исполняться в отдельном потоке (запускаем задачу в нововм потоке)
                otherTask2.fork(); // говорим что задача должна исполняться в отдельном потоке (запускаем задачу в нововм потоке)
                return otherTask2.join() + otherTask1.join(); // ожидаем завершение подзадач и возвр-м сумму результата
            }
        }
    }

    public static void main(String[] args) {
        double[] weights = new double[20];
        ForkJoinTask<Double> task = new WeightAnimalTask(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        double sum = pool.invoke(task);

        System.out.println();
        System.out.println("Weights:");
        for (double d: weights) System.out.print(d + ", ");
        System.out.println("");
        System.out.println("Sum: " + sum);
    }
}
