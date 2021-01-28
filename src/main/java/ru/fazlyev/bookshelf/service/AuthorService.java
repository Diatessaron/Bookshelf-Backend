package ru.fazlyev.bookshelf.service;

import ru.fazlyev.bookshelf.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findByName(String name);

    List<Author> findAll();
}
