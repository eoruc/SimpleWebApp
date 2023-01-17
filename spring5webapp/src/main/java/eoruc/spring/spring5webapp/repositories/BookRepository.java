package eoruc.spring.spring5webapp.repositories;

import eoruc.spring.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
