package ru.fazlyev.bookshelf.service;

import ru.fazlyev.bookshelf.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> findByName(String name);

    List<Genre> findAll();
}
