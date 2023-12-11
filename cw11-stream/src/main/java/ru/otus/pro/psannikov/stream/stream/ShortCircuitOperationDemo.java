package ru.otus.pro.psannikov.stream.stream;

import java.util.stream.Stream;

public class ShortCircuitOperationDemo {

    public static void main(String... args) {
        Integer number = Stream.of(1, 2, 5, 4, 3)
                               .filter(item -> {
                                   System.out.println("--" + item);
                                   return item > 2;
                               })
                               .sorted()
                               .findAny()
                               .orElse(null);

        System.out.println(number);
    }
}
