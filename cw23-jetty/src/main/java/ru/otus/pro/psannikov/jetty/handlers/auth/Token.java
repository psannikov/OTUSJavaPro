package ru.otus.pro.psannikov.jetty.handlers.auth;

import lombok.Getter;

import java.util.Objects;


public class Token {
    @Getter
    private final String token;

    public Token(final String token) {
        this.token = token;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Token token1 = (Token) o;
        return Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
