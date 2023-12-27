package ru.otus.pro.psannikov.cw12.creational_patterns;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class ObjectPool {
    public static void main(String[] args) {
        CarObjectPool<CarForPool> carObjectPool = new CarObjectPool<>(CarForPool :: new);
        CarForPool one = carObjectPool.acquire();
        one.carNumber = 1;
        CarForPool two = carObjectPool.acquire();
        two.carNumber = 2;
        System.out.println(one.carNumber);
        System.out.println(two.carNumber);
        carObjectPool.release(one);
        CarForPool three = carObjectPool.acquire();
        System.out.println(three.carNumber);
    }
}
@RequiredArgsConstructor
final class CarObjectPool<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final Supplier<T> newObj;
    public T acquire() {
        if (queue.isEmpty())
            return newObj.get();
        return queue.remove();
    }
    public void release(T obj) {
        queue.add(obj);
    }
}
class CarForPool {
    public int carNumber;
}
