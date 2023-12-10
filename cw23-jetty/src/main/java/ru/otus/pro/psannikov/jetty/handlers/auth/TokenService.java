package ru.otus.pro.psannikov.jetty.handlers.auth;

import java.util.Base64;
import java.util.HashMap;


public class TokenService {
    private final HashMap<String, Token> tokensByKey = new HashMap<>();

    public TokenService() {
        createToken("service", "password");
        createToken("test", "test");
    }

    public Token getToken(String login, String password) {
        return tokensByKey.get(getKey(login, password));
    }

    public void createToken(String login, String pwd) {
        Token token = new Token(new String(Base64.getEncoder().encode((login + "-" + login + "data").getBytes())));
        tokensByKey.put(getKey(login, pwd), token);
    }

    public boolean checkToken(String token) {
        Token tokenToCheck = new Token(token);
        return tokensByKey.values().stream().anyMatch(value -> value.equals(tokenToCheck));
    }

    private String getKey(String name, String pwd) {
        return name + "-" + pwd;
    }
}
