package mk.ukim.finki.emt.repository;

import mk.ukim.finki.emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
