package ru.otus.psannikov.triubleshooting.app1;

import org.junit.jupiter.api.RepeatedTest;
import ru.otus.pro.psannikov.troubleshooting.app1.ConcurrentDataStructuresDemo;

class ConcurrentDataStructuresDemoTest {
    @RepeatedTest(10)
    void helloTest() throws InterruptedException {
        ConcurrentDataStructuresDemo.main(new String[0]);
    }
}