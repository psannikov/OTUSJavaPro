package ru.otus.pro.psannikov.hw07.patterns.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectForMessage {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> copyData() {
        return new ArrayList<>(this.data);
    }

    public ObjectForMessage(List<String> data) {
        this.data = data;
    }

    public ObjectForMessage() {
    }
}
