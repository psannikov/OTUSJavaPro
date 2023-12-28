package ru.otus.pro.psannikov.spring.data.jdbc.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Genre;

@Getter
@Setter
@NoArgsConstructor
public class DetailedBookDto {
    private Long id;
    private String title;
    private Genre genre;
    private String authorName;
    private String description;
}
