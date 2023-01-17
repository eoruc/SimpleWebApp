package eoruc.spring.spring5webapp.bootstrap;

import eoruc.spring.spring5webapp.domain.Author;
import eoruc.spring.spring5webapp.domain.Book;
import eoruc.spring.spring5webapp.domain.Publisher;
import eoruc.spring.spring5webapp.repositories.AuthorRepository;
import eoruc.spring.spring5webapp.repositories.BookRepository;
import eoruc.spring.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author("Agathe", "Christie");
        Book b1 = new Book("And Then They Were None", "651781");

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        authorRepository.save(a1);
        bookRepository.save(b1);

        Author a2 = new Author("Frank", "Herbert");
        Book b2 = new Book("Dune", "7213839");

        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);

        authorRepository.save(a2);
        bookRepository.save(b2);

        Publisher p1 = new Publisher("İthaki Yayinevi", "Koru Mah.", "Ankara", "Cankaya", "06810");
        Publisher p2 = new Publisher("Can Yayinevi", "Umitkoy Mah.", "Ankara", "Cankaya", "06888");

        publisherRepository.save(p1);
        publisherRepository.save(p2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers:" + publisherRepository.count());
    }
}
