package ru.otus.pro.psannikov.cache.engine.crm.model;

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

