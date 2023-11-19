package ru.otus.pro.psannikov.nosql.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class BookMongo {

    private final String id;
    private final String title;
    private final String author;
    private final String subject;
    private final String publisher;

}
