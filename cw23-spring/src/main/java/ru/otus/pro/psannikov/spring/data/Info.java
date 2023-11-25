package ru.otus.pro.psannikov.spring.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Info {
    private final String serverName;
    private final String version;

}
