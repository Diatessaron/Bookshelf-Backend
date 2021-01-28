package ru.fazlyev.bookshelf.service;

import ru.fazlyev.bookshelf.domain.Book;
import ru.fazlyev.bookshelf.dto.BookRequest;

import java.util.List;

public interface BookService {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor_Name(String name);

    List<Book> findByGenre_Name(String name);

    List<Book> findByReadIsFalse();

    List<Book> findByReadIsTrue();

    List<Book> findByLikedIsTrue();

    List<Book> findAll();

    boolean setLiked(BookRequest book);

    boolean setRead(BookRequest book);
}
