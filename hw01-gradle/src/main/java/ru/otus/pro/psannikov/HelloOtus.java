package ru.otus.pro.psannikov;

import com.google.common.base.Joiner;
import java.util.Arrays;

public class HelloOtus {
    public static void main(String[] args) {
        System.out.println("Use Joiner from Guava for concat array data, sep |, skip Null");
        System.out.println(Joiner.on("|")
                .skipNulls()
                .join(Arrays.asList(1, null, true, "sdf", 3f, 5d, null, 'c')));
    }

}
