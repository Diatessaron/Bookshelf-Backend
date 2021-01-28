package ru.fazlyev.bookshelf.service;

import org.springframework.stereotype.Service;
import ru.fazlyev.bookshelf.domain.Genre;
import ru.fazlyev.bookshelf.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Genre> findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
