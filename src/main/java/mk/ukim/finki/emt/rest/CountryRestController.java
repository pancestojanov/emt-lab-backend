package mk.ukim.finki.emt.rest;

import mk.ukim.finki.emt.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mk.ukim.finki.emt.service.CountryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> create(@RequestBody Country country) {
        return this.countryService.create(country)
                .map(country1 -> ResponseEntity.ok().body(country1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
