package ru.otus.pro.psannikov.stream.stream;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorTrySplitDemo {

    public static void main(String... args) {
        List<String> letters = List.of("a", "b", "c", "d");
        Spliterator<String> sp1 = letters.spliterator();
        Spliterator<String> sp2 = sp1.trySplit();
        Spliterator<String> sp3 = sp2.trySplit();

        sp1.forEachRemaining(letter -> System.out.println("1--" + letter));
        sp2.forEachRemaining(letter -> System.out.println("2--" + letter));
        sp3.forEachRemaining(letter -> System.out.println("3--" + letter));
    }

}
