package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.dto.AuthorDto;
import mk.ukim.finki.emt.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    //Optional<Author> create(String name, String surname, Long countryId);

    Optional<Author> create(AuthorDto authorDto);
}
