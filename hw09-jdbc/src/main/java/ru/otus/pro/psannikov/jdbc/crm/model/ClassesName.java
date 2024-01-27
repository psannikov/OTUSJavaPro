package ru.otus.pro.psannikov.jdbc.crm.model;

public enum ClassesName {
    CLIENT("Client"),
    MANAGER("Manager");

    private String title;
    ClassesName(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

