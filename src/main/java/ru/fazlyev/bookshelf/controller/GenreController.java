package ru.fazlyev.bookshelf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fazlyev.bookshelf.domain.Genre;
import ru.fazlyev.bookshelf.service.GenreService;

import java.util.List;

@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/bookshelf/api/genres/{name}")
    public ResponseEntity<Genre> findByName(@PathVariable String name){
        return ResponseEntity.of(genreService.findByName(name));
    }

    @GetMapping("/bookshelf/api/genres")
    public ResponseEntity<List<Genre>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.findAll());
    }
}
