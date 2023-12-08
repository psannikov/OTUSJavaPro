package ru.otus.pro.psannikov.stream.stream;

import java.util.List;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class ParallelStreamDemo {

    public static void main(String... args) {
//        foo();
        bar();
    }

    public static void foo() {
        long time = System.currentTimeMillis();

//        OptionalLong opt = LongStream.range(0, 1_000_000_000).reduce(Long::sum);
        OptionalLong opt = LongStream.range(0, 1_000_000_000).parallel().reduce(Long::sum);
        System.out.println(opt.getAsLong());

        System.out.println(System.currentTimeMillis() - time);
    }

    public static void bar() {
        List<Double> list = List.of(10.0, 5.0, 1.0, 0.25);

        double sumResult = list.parallelStream()
                               .reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("sumResult = " + sumResult);

        double divisionResult = list.parallelStream()
                                    .reduce((accumulator, element) -> accumulator / element).get();
        System.out.println(divisionResult);
    }

}
