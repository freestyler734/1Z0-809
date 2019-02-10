package com.company.functionalProgramming.stream;

        import java.util.*;
        import java.util.function.*;
        import java.util.stream.Collector;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class StreamMethods {

    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(21);
        list.add(1);
        list.add(5);
        list.add(89);

        Map<String, Integer> map = new HashMap<>();
        ////////////////////////////////
        /// Примеры создания Стримов ///
        /// Стримы пересоздаются, т.к. их нельзя использовать повторно(после терминальных операций) ///
        // Конечные
        Stream<Integer> emptyStream = Stream.empty();
        Stream<Integer> singleElStream = Stream.of(2); // один элемент (T t)
        Stream<Integer> varargsStream = Stream.of(0,12,3,4,5); // varargs
        Stream<Integer> collectionStream = list.stream();
        // Бесконечные
        Stream<Double> supplierStream = Stream.generate(Math::random);
        Stream<Integer> unOperatorStream = Stream.iterate(1, n -> n+2);
        System.out.println("Stream.iterate(1, n -> n + 1): " + Stream.iterate(1, n -> n + 1));




        //////////////////////////////////////
        /// Основные терминальные операции ///
        // count()
        System.out.println("emptyStream.count()): " + emptyStream.count());
        System.out.println("varargsStream.count(): " + varargsStream.count());
        // System.out.println("supplierStream.count(): " + supplierStream.count()); // висит т.к. бесконечный стрим
        System.out.println("----------------------");

        // min(), max()
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        unOperatorStream = Stream.iterate(1, n -> n+2);
        emptyStream = Stream.empty();
        System.out.println("varargsStream.max((i1, i2) -> i1 - i2).get(): " + varargsStream.max((i1, i2) -> i1 - i2).get());
        // System.out.println("unOperatorStream.min((i1, i2) -> i1 - i2).get(): " + unOperatorStream.min((i1, i2) -> i1 - i2).get()); // висит т.к. бесконечный стрим
        System.out.println("emptyStream.min((i1, i2) -> i1 - i2).isPresent(): " + emptyStream.min((i1, i2) -> i1 - i2).isPresent());
        System.out.println("----------------------");

        // findFirst(), findAny()
        Stream<Integer> varargsStream1 = Stream.of(0,12,3,4,5); // varargs
        Stream<String> varargsStream2 = Stream.of("A","B","C"); // varargs
        unOperatorStream = Stream.iterate(1, n -> n+2);
        emptyStream = Stream.empty();
        System.out.println("varargsStream1.findFirst().get(): " + varargsStream1.findFirst().get());
        System.out.println("varargsStream2.findAny().get(): " + varargsStream2.findAny().get());
        System.out.println("unOperatorStream.findAny().get(): " + unOperatorStream.findAny().get());
        System.out.println("emptyStream.findAny().isPresent(): " + emptyStream.findAny().isPresent());
        System.out.println("----------------------");

        // allMatch(), anyMatch(), noneMatch()
        supplierStream = Stream.generate(() -> 1.);
        unOperatorStream = Stream.iterate(1, n -> 1);
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        varargsStream1 = Stream.of(0,12,3,4,5); // varargs
        Predicate<Integer> predicate = i -> i >= 0;
        //System.out.println("supplierStream.allMatch((d) -> d == 1): " + supplierStream.allMatch((d) -> d == 1)); // висит
        System.out.println("unOperatorStream.anyMatch(predicate): " + unOperatorStream.anyMatch(predicate)); // прерывает бесконечный стрим
        System.out.println("varargsStream.anyMatch(predicate): " + varargsStream.anyMatch(predicate));
        System.out.println("varargsStream1.noneMatch(predicate): " + varargsStream1.noneMatch(predicate));
        System.out.println("----------------------");

        // forEach()
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        unOperatorStream = Stream.iterate(1, n -> n+2);
        System.out.println("varargsStream.forEach((e) -> System.out.println(e)): ");
        varargsStream.forEach((e) -> System.out.print(e + 5 + ", "));
        // unOperatorStream.forEach(System.out::print); // печатает бесконечно
        System.out.println();
        System.out.println("----------------------");

        // reduce() - Очевидно, что не прерывает бесконечные стримы
        // 1) T reduce(T identity, BinaryOperator<T> accumulator)
        System.out.println("T reduce(T identity, BinaryOperator<T> accumulator):");
        emptyStream = Stream.empty();
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        BinaryOperator<Integer> accumulator = (i1, i2) -> i1 + i2; // сумма элементов
        int identity = 10; // будет автоупаковка в Integer
        System.out.println("emptyStream.reduce(identity, accumulator): " + emptyStream.reduce(identity, accumulator));
        System.out.println("varargsStream.reduce(identity, accumulator): " + varargsStream.reduce(identity, accumulator));
        System.out.println("-");
        // 2) Optional<T> reduce(BinaryOperator<T> accumulator):
        System.out.println("Optional<T> reduce(BinaryOperator<T> accumulator):");
        emptyStream = Stream.empty();
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        System.out.println("emptyStream.reduce(accumulator).isPresent(): " + emptyStream.reduce(accumulator).isPresent());
        System.out.println("varargsStream.reduce(accumulator).get(): " + varargsStream.reduce(accumulator).get());
        System.out.println("singleElStream.reduce(accumulator).get(): " + singleElStream.reduce(accumulator).get());
        System.out.println("-");
        // 3) <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner):
        System.out.println("<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner):");
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        BiFunction<Integer, Integer, Integer> accum = (i1, i2) -> i1 + i2;
        BinaryOperator<Integer> combiner = (i1, i2) -> i1 + i2; // работает только для параллельных стримов
        identity = 0;
        System.out.println("varargsStream.reduce(identity, accumulator, combiner)): " + varargsStream.reduce(identity, accumulator, combiner));
        System.out.println("----------------------");

        // collect() - Очевидно, что не прерывает бесконечные стримы
        // 1) <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
        // Пример с конкатенацией элементов в StringBuilder
        System.out.println(" <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner):");
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        BiConsumer<StringBuilder, Integer> accumulator2 =  (accumObj, currentObj) -> accumObj.append(currentObj);
        BiConsumer<StringBuilder, StringBuilder> combiner2 =  (accumObj1, accumObj2) -> accumObj1.append(accumObj2);
        System.out.println("varargsStream.collect(supplier, accumulator2, combiner2): " + varargsStream.collect(supplier, accumulator2, combiner2));
        // Пример с добавлением в коллекцию
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        Supplier<ArrayList> supplier2 = ArrayList::new;
        BiConsumer<ArrayList, Integer> accumulator3 =  ArrayList::add;
        BiConsumer<ArrayList, ArrayList> combiner3 = ArrayList::addAll;
        System.out.println("varargsStream.collect(supplier2, accumulator3, combiner3): " + varargsStream.collect(supplier2, accumulator3, combiner3));
        // 2) <R, A> collect(Collector<? super T, A, R> collector)
        varargsStream = Stream.of(0,12,3,4,5); // varargs
        Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
        System.out.println("varargsStream.collect(Collectors.toList()): " + varargsStream.collect(collector));
        System.out.println("----------------------");





        ///////////////////////////////////////
        /// Основные промежуточные операции ///
        // Stream<T> filter(Predicate<T> predicate)
        varargsStream = Stream.of(9,-2,-44,2,15,-765,21,-3);
        System.out.print("varargsStream.filter(i -> i >= 0).forEach(i -> System.out.print(i + \", \")): ");
        varargsStream.filter(i -> i >= 0).forEach(i -> System.out.print(i + ", "));
        System.out.println("\n----------------------");

        // Stream<T> distinct()
        varargsStream = Stream.of(9,-3,-44,-3,9,-765,21,-3);
        System.out.print("varargsStream.distinct().forEach(i -> System.out.print(i + \", \")): ");
        varargsStream.distinct().forEach(i -> System.out.print(i + ", "));
        System.out.println("\n----------------------");

        // Stream<T> limit(int maxSize)
        varargsStream = Stream.of(9,-3,-44,-3,9,-765,21,-3);
        unOperatorStream = Stream.iterate(1, n -> n+2);
        System.out.print("varargsStream.limit(5).forEach(i -> System.out.print(i + \",\")): ");
        varargsStream.limit(5).forEach(i -> System.out.print(i + ","));
        System.out.print("unOperatorStream.limit(5).forEach(i -> System.out.print(i + \", \")): ");
        unOperatorStream.limit(5).forEach(i -> System.out.print(i + ", ")); // делает бесконечный стрим конечным
        System.out.println("\n----------------------");

        // Stream<T> skip(int n)
        varargsStream = Stream.of(9,-3,-44,-3,9,-765,21,-3);
        unOperatorStream = Stream.iterate(1, n -> n+2);
        System.out.print("varargsStream.skip(5).forEach(i -> System.out.print(i + \",\")): ");
        varargsStream.skip(5).forEach(i -> System.out.print(i + ","));
        //System.out.print("unOperatorStream.limit(5).forEach(i -> System.out.print(i + \", \")): ");
        //unOperatorStream.skip(5).forEach(i -> System.out.print(i + ", ")); // делает висит
        System.out.println("\n----------------------");

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        varargsStream = Stream.of(9,-3,-44,-3,9,-765,21,-3);
        Function<Integer, String> mapper = i -> "число: " + i;
        System.out.println("varargsStream.map(mapper).forEach(s -> System.out.print(s + \", \")): ");
        varargsStream.map(mapper).forEach(s -> System.out.print(s + ", "));
        System.out.println("\n----------------------");

        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>>)
        List<String> list1 = Arrays.asList("1", null, "2");
        List<String> list2 = Arrays.asList("3", "4", "5");
        List<String> list3 = Arrays.asList(null, "6", "7");
        List<String> list4 = Arrays.asList();
        Stream<List<String>> listStream = Stream.of(list1, list2, list3, list4);
        Function<List<String>, Stream<String>> flatMapper = l -> l.stream();
        Stream<String> stringStream = listStream.flatMap(flatMapper);
        System.out.println("listStream.flatMap(l -> l.stream()).forEach(s -> System.out.print(s + \", \")): ");
        stringStream.forEach(s -> System.out.print(s + ", "));
        System.out.println("\n----------------------");

        // Stream<R> oredered()
        // Stream<R> oredered(Comparator<? super T> comparator)
        Stream<String> stringStream1 = Stream.of("b", "c", "d", "a");
        System.out.println("stringStream1.sorted().forEach(s -> System.out.print(s + \", \")): ");
        stringStream1.sorted().forEach(s -> System.out.print(s + ", "));
        System.out.println("");
        stringStream1 = Stream.of("b", "c", "d", "a");
        System.out.println("stringStream1.sorted((s1, s2) -> s2.compareTo(s1)).forEach(s -> System.out.print(s + \", \"))");
        stringStream1.sorted((s1, s2) -> s2.compareTo(s1)).forEach(s -> System.out.print(s + ", "));
        System.out.println("\n----------------------");

        // Stream<T> peek(Consumer<? super T> action)
        Stream<StringBuilder> stream = Stream.of(new StringBuilder(), new StringBuilder(), new StringBuilder());
        System.out.println("stream.peek(sb -> sb.append(\"asd\")).forEach(s -> System.out.print(s.toString() + \", \"))");
        stream.peek(sb -> sb.append("asd")).forEach(s -> System.out.print(s.toString() + ", "));// лучше так не делать

    }

}
