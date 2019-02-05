package com.company.functionalProgramming.funcInterfaceImplementing;

import java.util.function.*;

public class PrimitiveFunctionalInterfaces {

    public static void main(String[] args) {

        // Supplier
        BooleanSupplier booleanSupplier = () -> true;
        boolean boolValue = booleanSupplier.getAsBoolean();
        IntSupplier intSupplier = () -> 1;
        int intValue = intSupplier.getAsInt();
        DoubleSupplier doubleSupplier = () -> 0.1;
        double doubleValue = doubleSupplier.getAsDouble();
        LongSupplier longSupplier = () -> 320000000000000000L;
        long longValue = longSupplier.getAsLong();

        // Consumer
        IntConsumer intConsumer = i -> i++;
        intConsumer.accept(1);
        LongConsumer longConsumer = l -> l += 1000000000000000L;
        longConsumer.accept(100000000000000L);
        DoubleConsumer doubleConsumer = d -> d += 0.1;
        doubleConsumer.accept(1.);

        // Predicate
        IntPredicate intPredicate = i -> i >= 0;
        boolean intPredicateResult = intPredicate.test(1);
        DoublePredicate doublePredicate = d -> d == 0.3;
        boolean doublePredicateResult = doublePredicate.test(0.3);
        LongPredicate longPredicate = l -> l > 1000000000000000L;
        boolean longPredicateResult = longPredicate.test(10000000000000000L);

        // Function
        IntFunction<String> intFunction = i -> "i: " + i;
        String intFunctionResult = intFunction.apply(20);
        DoubleFunction<String> doubleFunction = d -> "d: " + d;
        String doubleFunctionResult = doubleFunction.apply(.1);
        LongFunction<String> longFunction = l -> "l: " + l;
        String longFunctionResult = longFunction.apply(1000000000000000L);

        // UnaryOperator
        IntUnaryOperator intUnaryOperator = i -> i + 1;
        int intUnaryOperatorResult = intUnaryOperator.applyAsInt(1);
        DoubleUnaryOperator doubleUnaryOperator = d -> d + .1;
        double doubleUnaryOperatorResult = doubleUnaryOperator.applyAsDouble(.3);
        LongUnaryOperator longUnaryOperator = l -> l + 1L;
        long longUnaryOperatorResult = longUnaryOperator.applyAsLong(10000000000L);

        // BinaryOperator
        IntBinaryOperator intBinaryOperator = (i1, i2) -> i1 + i2;
        int intBinaryOperatorResult = intBinaryOperator.applyAsInt(1,2);
        DoubleBinaryOperator doubleBinaryOperator = (d1, d2) -> d1 + d2;
        double doubleBinaryOperatorResult = doubleBinaryOperator.applyAsDouble(.1,.2);
        LongBinaryOperator longBinaryOperator = (l1, l2) -> l1 * l2;
        long longBinaryOperatorResult = longBinaryOperator.applyAsLong(1L, 2L);

        // To"Тип"Function
        ToIntFunction<String> toIntFunction = s -> Integer.parseInt(s);
        int toIntFunctionResult = toIntFunction.applyAsInt("1");
        ToDoubleFunction<String> toDoubleFunction = s -> Double.parseDouble(s);
        double toDoubleFunctionResult = toDoubleFunction.applyAsDouble("0.4");
        ToLongFunction<String> toLongFunction = s -> Long.parseLong(s);
        long toLongFunctionResult = toLongFunction.applyAsLong("11111111");

        // To"Тип"BiFunction
        ToIntBiFunction<Integer, String> toIntBiFunction = (i, s) -> Integer.parseInt(s) + i.intValue();
        int toIntBiFunctionResult = toIntBiFunction.applyAsInt(new Integer(1), "2");
        ToDoubleBiFunction<Integer, String> toDoubleBiFunction = (i, s) -> Double.parseDouble(s) + i.intValue();
        double toDoubleBiFunctionResult = toDoubleBiFunction.applyAsDouble(new Integer(1), "0.3");
        ToLongBiFunction<Integer, String> toLongBiFunction = (i, s) -> Long.parseLong(s) + i.intValue();
        long toLongBiFunctionResult = toLongBiFunction.applyAsLong(new Integer(1), "100000000000000");

        // "Тип1"To"Тип2"Function
        DoubleToIntFunction doubleToIntFunction = d -> (int)d;
        int doubleToIntFunctionResult = doubleToIntFunction.applyAsInt(.1);
        DoubleToLongFunction doubleToLongFunction = d -> (long)d;
        long doubleToLongFunctionResult = doubleToLongFunction.applyAsLong(1L);
        IntToDoubleFunction intToDoubleFunction = i -> i + .1;
        double intToDoubleFunctionResult = intToDoubleFunction.applyAsDouble(1);
        IntToLongFunction intToLongFunction = i -> i + 100000000000L;
        long intToLongFunctionResult = intToLongFunction.applyAsLong(1);
        LongToDoubleFunction longToDoubleFunction = l -> l + .1;
        double longToDoubleFunctionResult = longToDoubleFunction.applyAsDouble(100000000000L);
        LongToIntFunction longToIntFunction = l -> (int)l;
        int longToIntFunctionResult = longToIntFunction.applyAsInt(100000000000000000L);

        // Obj"Тип"Consumer
        ObjIntConsumer<String> objIntConsumer = (s, i) -> System.out.println(s + i);
        objIntConsumer.accept("int: ", 1);
        ObjDoubleConsumer<String> objDoubleConsumer = (s, d) -> System.out.println(s + d);
        objDoubleConsumer.accept("double: ", .3);
        ObjLongConsumer<String> objLongConsumer = (s, l) -> System.out.println(s + l);
        objLongConsumer.accept("long: ", 10000L);
    }
}
