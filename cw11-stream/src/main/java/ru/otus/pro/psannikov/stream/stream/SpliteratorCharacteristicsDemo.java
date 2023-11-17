package ru.otus.pro.psannikov.stream.stream;

import scala.collection.mutable.TreeSet;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

public class SpliteratorCharacteristicsDemo {

    public static void main(String... args) {
//        Collection<String> letters = List.of("a", "b", "c", "d");
        Collection<String> letters = Set.of("a", "b", "c", "d");
        Spliterator<String> sp = letters.spliterator();

        int mask = sp.characteristics();

        System.out.println("sized: " + ((mask & Spliterator.SIZED) != 0));
        System.out.println("sorted: " + ((mask & Spliterator.SORTED) != 0));
        System.out.println("subsized: " + ((mask & Spliterator.SUBSIZED) != 0));
        System.out.println("concurrent: " + ((mask & Spliterator.CONCURRENT) != 0));
        System.out.println("distinct: " + ((mask & Spliterator.DISTINCT) != 0));
        System.out.println("immutable: " + ((mask & Spliterator.IMMUTABLE) != 0));
        System.out.println("nonnull: " + ((mask & Spliterator.NONNULL) != 0));
        System.out.println("ordered: " + ((mask & Spliterator.ORDERED) != 0));
    }

}
