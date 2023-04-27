package mk.ukim.finki.emt.service.impl;

import mk.ukim.finki.emt.model.Country;
import mk.ukim.finki.emt.model.dto.AuthorDto;
import mk.ukim.finki.emt.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emt.repository.AuthorRepository;
import mk.ukim.finki.emt.repository.CountryRepository;
import mk.ukim.finki.emt.service.AuthorService;
import mk.ukim.finki.emt.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

//    @Override
//    @Transactional
//    public Author create(String name, String surname, Long countryId) {
//        Country country = this.countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
//        return this.authorRepository.save(new Author(name, surname, country));
//    }

    @Override
    public Optional<Author> create(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountry()).orElseThrow(InvalidCountryIdException::new);
        return Optional.of(this.authorRepository.save(new Author(authorDto.getName(), authorDto.getSurname(), country)));
    }
}
