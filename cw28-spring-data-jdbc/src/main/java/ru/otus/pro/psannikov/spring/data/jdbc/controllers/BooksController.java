package ru.otus.pro.psannikov.spring.data.jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.CreateOrUpdateCategoryDtoRq;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.DetailedBookDto;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Book;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Category;
import ru.otus.pro.psannikov.spring.data.jdbc.repositories.BooksRepository;
import ru.otus.pro.psannikov.spring.data.jdbc.services.BooksService;
import ru.otus.pro.psannikov.spring.data.jdbc.services.impl.BooksServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    private final BooksServiceImpl booksService;

    @Autowired
    public BooksController(BooksServiceImpl booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<DetailedBookDto> findAllDetailedBooks() {
        return booksService.findAllDetailedBooks();
    }
    @PatchMapping("/{id}/title")
    public void changeTitleById(@PathVariable Long id, @RequestParam String value) {
        booksService.updateTitleById(id, value);
    }
}
