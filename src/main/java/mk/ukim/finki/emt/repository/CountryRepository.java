package mk.ukim.finki.emt.repository;

import mk.ukim.finki.emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
