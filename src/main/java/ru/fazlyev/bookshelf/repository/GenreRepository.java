package ru.fazlyev.bookshelf.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.fazlyev.bookshelf.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Optional<Genre> findByName(String name);
}
