package com.company.functionalProgramming.stream;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExamples {

    public static void main(String[] args) {
        // Примеры использования готовых коллекторов

        // joining
        Stream<String> stringStream = Stream.of("1", "2", "3", "4");
        String joiningResult = stringStream.collect(Collectors.joining(", "));
        stringStream = Stream.of("1", "2", "3", "4");
        joiningResult = stringStream.collect(Collectors.joining());
        System.out.println(joiningResult);

        // avereging"Тип" - рез-т всегда Double
        stringStream = Stream.of("1", "2", "3", "4");
        Double avg1 = stringStream.collect(Collectors.averagingInt(Integer::parseInt)); // To"Тип"Function
        stringStream = Stream.of("1", "2", "3", "4");
        Double avg2 = stringStream.collect(Collectors.averagingDouble(Double::parseDouble));
        stringStream = Stream.of("1", "2", "3", "4");
        Double avg3 = stringStream.collect(Collectors.averagingLong(Long::parseLong));

        // counting -  рез-т Long
        stringStream = Stream.of("1", "2", "3", "4");
        Long count = stringStream.collect(Collectors.counting());

        // maxBy/minBy
        stringStream = Stream.of("1", "2", "3", "4");
        Optional<String> min = stringStream.collect(Collectors.minBy(Comparator.naturalOrder()));
        stringStream = Stream.of("1", "2", "3", "4");
        Optional<String> max = stringStream.collect(Collectors.maxBy(Comparator.naturalOrder()));

        // toCollection
        stringStream = Stream.of("1", "2", "3", "4");
        ArrayList<String> stringArrayList = stringStream.collect(Collectors.toCollection(ArrayList::new)); // Supplier
        stringStream = Stream.of("1", "2", "3", "4");
        HashSet<String> stringHashSet = stringStream.collect(Collectors.toCollection(HashSet::new)); // Supplier

        // summarizing"Тип" - рез-т "Тип"SummaryStatistics
        stringStream = Stream.of("1", "2", "3", "4");
        IntSummaryStatistics intStatistics = stringStream.collect(Collectors.summarizingInt(Integer::parseInt)); // ToIntFunction
        stringStream = Stream.of("1", "2", "3", "4");
        DoubleSummaryStatistics doubleStatistics = stringStream.collect(Collectors.summarizingDouble(Double::parseDouble)); // ToDoubleFunction
        stringStream = Stream.of("1", "2", "3", "4");
        LongSummaryStatistics longStatistics = stringStream.collect(Collectors.summarizingLong(Long::parseLong)); // ToLongFunction

        // summing"Тип" - рез-т "Тип"
        stringStream = Stream.of("1", "2", "3", "4");
        int intSum = stringStream.collect(Collectors.summingInt(Integer::parseInt)); // ToIntFunction
        stringStream = Stream.of("1", "2", "3", "4");
        double doubleSum = stringStream.collect(Collectors.summingDouble(Double::parseDouble)); // ToDoubleFunction
        stringStream = Stream.of("1", "2", "3", "4");
        long longSum = stringStream.collect(Collectors.summingLong(Long::parseLong)); // ToLongFunction

        // toList/toSet (случайные реализации)
        List<String> list = Stream.of("1", "2", "3", "4").collect(Collectors.toList());
        Set<String> set = Stream.of("1", "2", "3", "4").collect(Collectors.toSet());

        // toMap() - конвертирует стрим в map,
        // существует несколько пергруженных версий
        // 1) toMap(Function k, Function v) - где функции определяют ключ и значение для каждой пары
        stringStream = Stream.of("1", "2", "3", "4");
        Map<Integer, String> map1 = stringStream.collect(Collectors.toMap(str -> Integer.parseInt(str), str -> str));
        System.out.println(map1);
        // 2) toMap(Function k, Function v, BinaryOperator merge) - в случае совпадения ключей, во избежание исключения
        // BiFunction - обрабатывает такие значения
        stringStream = Stream.of("1", "1", "3", "4");
        //Map<Integer, String> map2 = stringStream.collect(Collectors.toMap(str -> Integer.parseInt(str), str -> str)); // IllegalStateException: Duplicate key 1
        stringStream = Stream.of("1", "1", "3", "4");
        Map<Integer, String> map2 = stringStream.collect(Collectors.toMap(Integer::parseInt, str -> str, (str1, str2) -> str1+"/"+str2)); // сливаем 2 строчки в одну
        System.out.println(map2);
        // 3)  toMap(Function k, Function v, BinaryOperator merge, Supplier map) - Supplier предоставляет реализацию Map, т.к. иначе она м.б. любая
        stringStream = Stream.of("1", "4", "1", "3");
        TreeMap<Integer, String> map3 = stringStream.collect(Collectors.toMap(
                Integer::parseInt,
                str -> str + "lol",
                (str1, str2) -> str1 + "/" + str2,
                TreeMap::new
        ));
        System.out.println(map3);

        // groupingBy - группирует объекты по значению возвращаемой Function
        // для элемента, возвращает случайную реализацию Map. По умолчанию, группирует в List
        // 1) groupingBy(Function)
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        Map<Integer, List<String>> map4 = stringStream.collect(Collectors.groupingBy(str -> Integer.parseInt(str)));
        System.out.println(map4);
        // 2) groupingBy(Function, Collector) - Collector обрабатывает каждую группу
        // К примеру, можем в каждой группе можно посчитать сумму
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        Map<Integer, Integer> map5 = stringStream.collect(Collectors.groupingBy(Integer::parseInt, Collectors.summingInt(Integer::parseInt)));
        System.out.println(map5);
        // или преобразовать каждую группу в др. коллекцию
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        Map<Integer, TreeSet<String>> map6 = stringStream.collect(Collectors.groupingBy(Integer::parseInt, Collectors.toCollection(TreeSet::new)));
        System.out.println(map6);
        // 3) groupingBy(Function, Supplier, Collector) - Supplier - предоставление конкретной реализации Map
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        HashMap<Integer, Set<String>> map7 = stringStream.collect(Collectors.groupingBy(Integer::parseInt, HashMap::new, Collectors.toSet()));
        System.out.println(map7);

        // partitioningBy - под вид groupingBy, где вместо функции используется Predicate,
        // поэтому всегда получается только 2 группы (true и false). Однако, мы не можем выбрать реализацию Map
        // 1) partitioningBy(Predicate)
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        Map<Boolean, List<String>> map8 = stringStream.collect(Collectors.partitioningBy( str -> Integer.parseInt(str) > 5 ));
        System.out.println(map8);
        // 2) partitioningBy(Predicate, Collector)
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        Map<Boolean, Set<String>> map9 = stringStream.collect(Collectors.partitioningBy(str -> Integer.parseInt(str) > 5, Collectors.toSet()));
        System.out.println(map9);

        // mapping(Function, Collector) - способ обработать при groupingBy и partitionBy каждый элемент каждой группы коллектором
        stringStream = Stream.of("1", "1", "3", "4", "4", "6", "7", "9", "9");
        Map<String, Optional<Integer>> map10 = stringStream.collect(
                                                Collectors.groupingBy(
                                                        str -> Integer.parseInt(str) % 2 == 0 ? "Even" : "Not Even",
                                                        Collectors.mapping(Integer::parseInt,
                                                                           Collectors.minBy(Integer::compareTo))
                                                )
                                            ); // Находит мин. элемент в группе четных и нечетных элементов
        System.out.println(map10);

    }
}
