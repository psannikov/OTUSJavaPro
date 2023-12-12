package ru.otus.pro.psannikov.spring.data.jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.DetailedBookDto;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.PageDto;
import ru.otus.pro.psannikov.spring.data.jdbc.repositories.BooksRepository;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<DetailedBookDto> findAllDetailedBooks() {
        return booksRepository.findAllDetailedBooks();
    }

    public void updateTitleById(Long id, String newTitle) {
        booksRepository.changeTitleById(id, newTitle);
    }

    public PageDto findAllDetailedBooksPageDto(Long bookByPage, Long page) {
        Long countBooks = booksRepository.count();
        Long countPage = countBooks / bookByPage + 1;
        List<DetailedBookDto> detailedBookDtos = booksRepository.findAllDetailedBooksPagin(bookByPage, page);
        return new PageDto(detailedBookDtos, countBooks, page, bookByPage, countPage);
    }

    public DetailedBookDto findDetailedBooksById(Long id) {
        return booksRepository.findDetailedBooksById(id);
    }

    public List<DetailedBookDto> findTop10BookByReview() {
        return booksRepository.findTop10BookByReview();
    }

}
