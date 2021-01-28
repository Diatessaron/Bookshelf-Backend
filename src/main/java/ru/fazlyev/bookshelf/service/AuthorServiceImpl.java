package ru.fazlyev.bookshelf.service;

import org.springframework.stereotype.Service;
import ru.fazlyev.bookshelf.domain.Author;
import ru.fazlyev.bookshelf.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
