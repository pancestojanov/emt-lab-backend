package mk.ukim.finki.emt.service.impl;

import mk.ukim.finki.emt.model.dto.BookDto;
import mk.ukim.finki.emt.model.Author;
import mk.ukim.finki.emt.model.Book;
import mk.ukim.finki.emt.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.emt.model.exceptions.InvalidBookIdException;
import org.springframework.stereotype.Service;
import mk.ukim.finki.emt.repository.AuthorRepository;
import mk.ukim.finki.emt.repository.BookRepository;
import mk.ukim.finki.emt.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

//    @Override
//    @Transactional
//    public Book create(String name, Long authorId, Category category, Integer availableCopies) {
//        Author author = this.authorRepository.findById(authorId).orElseThrow(InvalidAuthorIdException::new);
//        return bookRepository.save(new Book(name, category, author, availableCopies));
//    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor().getId()).orElseThrow(InvalidAuthorIdException::new);
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }


//    @Override
//    @Transactional
//    public Book update(Long id, String name, Long authorId, Category category, Integer availableCopies) {
//        Book book = findById(id);
//        Author author = this.authorRepository.findById(authorId).orElseThrow(InvalidAuthorIdException::new);
//
//        book.setName(name);
//        book.setAuthor(author);
//        book.setCategory(category);
//        book.setAvailableCopies(availableCopies);
//
//        return this.bookRepository.save(book);
//    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto)    {
        Book book = findById(id).orElseThrow(InvalidBookIdException::new);
        Author author = this.authorRepository.findById(bookDto.getAuthor().getId()).orElseThrow(InvalidAuthorIdException::new);

        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = findById(id).orElseThrow(InvalidBookIdException::new);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
    }

}
