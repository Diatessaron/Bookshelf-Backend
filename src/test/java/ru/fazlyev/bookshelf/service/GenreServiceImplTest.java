package ru.fazlyev.bookshelf.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import ru.fazlyev.bookshelf.domain.Genre;
import ru.fazlyev.bookshelf.repository.BookRepository;
import ru.fazlyev.bookshelf.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class GenreServiceImplTest {
    @MockBean
    private GenreRepository genreRepository;
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private GenreServiceImpl service;

    private final Genre expectedNovel = new Genre("Modernist novel");

    @Test
    void shouldReturnCorrectGenreByName() {
        when(genreRepository.findByName(expectedNovel.getName())).thenReturn(java.util.Optional.of(expectedNovel));

        final Optional<Genre> actual = service.findByName(expectedNovel.getName());

        assertEquals(Optional.of(expectedNovel), actual);

        verify(genreRepository, times(1)).findByName(expectedNovel.getName());
    }

    @Test
    void shouldThrowExceptionAfterGetGenreByNameMethodInvocation() {
        assertThrows(IllegalArgumentException.class, () -> service.findByName("genre"));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void shouldReturnCorrectListOfGenre() {
        final List<Genre> expected = List.of(expectedNovel);

        when(genreRepository.findAll()).thenReturn(expected);

        final List<Genre> actual = service.findAll();

        assertThat(actual).isNotNull().matches(a -> a.size() == expected.size())
                .matches(a -> a.get(0).getName().equals(expected.get(0).getName()));

        verify(genreRepository, times(1)).findAll();
    }
}
