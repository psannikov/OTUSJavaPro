package ru.otus.pro.psannikov.stream.stream;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

    public static void main(String... args) {
        List<String> letters = List.of("a", "b", "c", "d");
        Spliterator<String> sp = letters.spliterator();

        boolean res = sp.tryAdvance(System.out::println);   // a
        res = sp.tryAdvance(System.out::println);   // b

        sp.forEachRemaining(letter -> System.out.println("--" + letter));
    }

}
