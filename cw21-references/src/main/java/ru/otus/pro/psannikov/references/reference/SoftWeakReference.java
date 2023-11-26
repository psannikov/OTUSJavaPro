package ru.otus.pro.psannikov.references.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftWeakReference {
    public static void main(String[] args) {
        Object obj = new Object();
        SoftReference<Object> softObj = new SoftReference<>(obj);
        WeakReference<Object> weakObj = new WeakReference<>(obj);
        obj = null;
        System.out.println("Софт до ГК " + softObj.get());
        System.out.println("Вик до ГК " + weakObj.get());
        System.gc();
        System.out.println("Софт после ГК " + softObj.get());
        System.out.println("Вик после ГК " + weakObj.get());
        softObj.clear();
        System.out.println("Софт после клеар до ГК " + softObj.get());
        System.out.println("Вик после клеар до ГК " + weakObj.get());
        System.gc();
        System.out.println("Софт после клеар после ГК " + softObj.get());
        System.out.println("Вик после клеар до ГК " + weakObj.get());
    }
}
