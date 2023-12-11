package ru.otus.pro.psannikov.stream.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationDemo {

    public static void main(String... args) {
        List<Integer> numbers = Stream.of(1, 2, 5, 4, 3)
                                      // stream 1
                                      .map(item -> {
                                          System.out.println("--" + item);
                                          return item;
                                      })
                                      // delimiter
                                      // .sorted()
                                      // stream 2
                                      .map(item -> {
                                          System.out.println("++" + item);
                                          return item;
                                      })
                                      .collect(Collectors.toList());


        System.out.println(numbers);
    }
}
