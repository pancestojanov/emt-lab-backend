package mk.ukim.finki.emt.service;

import mk.ukim.finki.emt.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> create(Country country);
}
