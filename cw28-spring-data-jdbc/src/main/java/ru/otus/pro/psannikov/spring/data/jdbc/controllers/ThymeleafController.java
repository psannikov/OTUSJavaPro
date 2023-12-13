package ru.otus.pro.psannikov.spring.data.jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.DetailedBookDto;
import ru.otus.pro.psannikov.spring.data.jdbc.services.BooksService;
import ru.otus.pro.psannikov.spring.data.jdbc.services.impl.BooksServiceImpl;

import java.util.List;

@Controller
public class ThymeleafController {
    private final BooksServiceImpl booksService;

    @Autowired
    public ThymeleafController(BooksServiceImpl booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/list")
    public String showAllBooksPage(Model model) {
        List<DetailedBookDto> list = booksService.findAllDetailedBooks();
        model.addAttribute("books", list);
        return "books";
    }
}
