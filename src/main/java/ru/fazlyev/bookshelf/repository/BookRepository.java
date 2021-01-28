package ru.fazlyev.bookshelf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.fazlyev.bookshelf.domain.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor_Name(String name);

    List<Book> findByGenre_Name(String name);

    List<Book> findByIsReadIsFalse();

    List<Book> findByIsReadIsTrue();

    List<Book> findByIsLikedIsTrue();
}
