package ru.fazlyev.bookshelf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.fazlyev.bookshelf.domain.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findByName(String name);
}
