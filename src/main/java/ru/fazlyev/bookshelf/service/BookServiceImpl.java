package ru.fazlyev.bookshelf.service;

import org.springframework.stereotype.Service;
import ru.fazlyev.bookshelf.domain.Book;
import ru.fazlyev.bookshelf.dto.BookRequest;
import ru.fazlyev.bookshelf.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByAuthor_Name(String name) {
        return bookRepository.findByAuthor_Name(name);
    }

    @Override
    public List<Book> findByGenre_Name(String name) {
        return bookRepository.findByGenre_Name(name);
    }

    @Override
    public List<Book> findByReadIsFalse() {
        return bookRepository.findByIsReadIsFalse();
    }

    @Override
    public List<Book> findByReadIsTrue() {
        return bookRepository.findByIsReadIsTrue();
    }

    @Override
    public List<Book> findByLikedIsTrue() {
        return bookRepository.findByIsLikedIsTrue();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean setLiked(BookRequest bookRequest) {
        final Book book = bookRepository.findById(bookRequest.getId()).orElseThrow(
                () -> new IllegalArgumentException("Incorrect book id has been entered"));
        book.setLiked(bookRequest.isLiked());
        bookRepository.save(book);

        return true;
    }

    @Override
    public boolean setRead(BookRequest bookRequest) {
        final Book book = bookRepository.findById(bookRequest.getId()).orElseThrow(
                () -> new IllegalArgumentException("Incorrect book id has been entered"));
        book.setRead(bookRequest.isRead());
        bookRepository.save(book);

        return true;
    }
}
