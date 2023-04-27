package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> findAll();
    //Optional<Book> create(String name, Long authorId, Category category, Integer availableCopies);

    Optional<Book> create(BookDto bookDto);

    //Optional<Book> update(Long id, String name, Long authorId, Category category, Integer availableCopies);

    Optional<Book> update(Long id, BookDto bookDto);

    void delete(Long id);

    void markAsTaken(Long id);


}
