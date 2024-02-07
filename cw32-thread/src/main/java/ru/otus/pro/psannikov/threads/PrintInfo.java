package ru.otus.pro.psannikov.threads;

public class PrintInfo {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println("---------------");
        thread.setName("new-main-thread-name");
        System.out.println("Name : " + thread.getName());
        System.out.println("Id : " + thread.getId());
        System.out.println("Priority : " + thread.getPriority());
        System.out.println("State : " + thread.getState());
    }
}
