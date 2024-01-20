package ru.otus.pro.psannikov.containers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConcurrentSkipListSetDemo {

    public static void main(String... args) throws InterruptedException {
        NavigableSet<Integer> numbers = new ConcurrentSkipListSet<>();

        for (int i = 0; i < 10; i++)
            numbers.add(i);

        System.out.println(numbers);
    }

}
