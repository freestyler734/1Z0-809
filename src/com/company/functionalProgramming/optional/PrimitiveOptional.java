package com.company.functionalProgramming.optional;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.LongSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveOptional {

    public static void main(String[] args) {

        /// Дополнительные терминальные операции примитивных стримов и ///
        ///         Примитивные Optional на примере IntStream          ///
        OptionalDouble optionalAvg = IntStream.range(1, 11).average();
        OptionalInt optionalMin = IntStream.range(1, 11).min();
        OptionalInt optionalMax = IntStream.range(1, 11).max();
        int sum = IntStream.range(1, 11).sum();

        System.out.println("IntStream.range(1, 11).average().getAsDouble(): " + optionalAvg.getAsDouble());
        System.out.println("IntStream.range(1, 11).min().getAsInt(): " + optionalMin.getAsInt());
        System.out.println("IntStream.range(1, 11).max().getAsInt(): " + optionalMax.getAsInt());
        System.out.println("IntStream.range(1, 11).sum(): " + sum); // Возвращает соответствующий примитив
        System.out.println("---------------------------");

        // Пример использования orElseGet, который использует "Тип"Supplier
        // и orElse, который использует соответствующий примитивный тип
        OptionalLong emptyOptionalLong = OptionalLong.empty();
        LongSupplier longSupplier = () -> 2L;
        System.out.println("emptyOptionalLong.orElseGet(longSupplier): " + emptyOptionalLong.orElseGet(longSupplier));
        System.out.println("emptyOptionalLong.orElse(3L): " + emptyOptionalLong.orElse(3L));
    }
}
