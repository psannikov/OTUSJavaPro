package ru.otus.pro.psannikov.cw13.behavioral_patterns.chain_of_responsibility.data;

import java.util.Objects;


public class Resource {
    private String name;

    public Resource(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Resource resource = (Resource) o;
        return Objects.equals(name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
