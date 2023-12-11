package ru.otus.pro.psannikov.spring.data.jdbc.services;

import ru.otus.pro.psannikov.spring.data.jdbc.dtos.DetailedBookDto;

import java.util.List;

public interface BooksService {
    public List<DetailedBookDto> findAllDetailedBooks();

    public void updateTitleById(Long id, String newTitle);
}
