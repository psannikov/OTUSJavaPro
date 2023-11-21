package ru.otus.pro.psannikov.spring.data;

public class Person {
    private Long id;
    private String name;
    private String address;

    public Person() {
    }

    public Person(final String name, final String address) {
        this (null, name, address);
    }

    public Person(final Long id, final String name, final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }
}
