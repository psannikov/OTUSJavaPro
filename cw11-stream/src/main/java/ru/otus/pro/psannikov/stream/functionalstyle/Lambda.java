package ru.otus.pro.psannikov.stream.functionalstyle;

import java.util.function.Function;
import java.util.function.IntSupplier;

public class Lambda {

    private String value;

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        String result = lambda.func(str -> str + "+mod", "testStr");
        System.out.println(result);

        int result2 = lambda.func(val -> val * 10, 5);
        System.out.println(result2);

        // "Билдер" экземпляров Lambda с инициализацией поля value константой
        Lambda l = lambda.func(lb -> {
            lb.value = "testValue";
            return lb;
        }, new Lambda());
        System.out.println(l.value);

        //int[] initValue - не поле инстанса или класса, но сохраняет свое значение между вызовами функции
        //Так работает, но ТАК ДЕЛАТЬ НЕ НАДО.
        IntSupplier closure = lambda.generator();
        System.out.println("1:" + closure.getAsInt());
        System.out.println("2:" + closure.getAsInt());
        System.out.println("3:" + closure.getAsInt());
    }


    private <T, R> R func(Function<T, R> func, T param) {
        return func.apply(param);
    }

    private IntSupplier generator() {
        int[] initValue = { 0 }; //Переменная не только effectively final, но и effectively private :)
        return () -> ++initValue[0];
    }
}
