package ru.otus.pro.psannikov.stream.functionalstyle;

import java.util.Optional;

public class MonadExample {

    public static void main(String... args) {
        MonadExample monadExample = new MonadExample();

        String result = monadExample.function("test");
        System.out.println(result);

        result = monadExample.function(null);
        System.out.println(result);

        result = monadExample.functionWrong(null);
        System.out.println(result);
    }

    private static String toUpeerCase(String str) throws Exception {
        return str.toUpperCase();
    }

    private String function(String str) {
        Optional<String> optional = Optional.ofNullable(str);

        optional.stream().map(s -> "!" + s.toUpperCase()).forEach(System.out::println);

        return Optional.ofNullable(str).map(param -> param + "+addStre").orElse("param is NULL");
    }

    // некорректное использование монады
    private String functionWrong(String str) {
        Optional<String> optional = Optional.ofNullable(str);

        if (optional.isPresent()) {
            return optional.get() + "+addStr";
        }

        return "param is NULL";
    }

    public interface Function1<T, R> {

        R apply(T t) throws Exception;
    }
}
