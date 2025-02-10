package com.example.demo8.bootstrap;

import com.example.demo8.domain.Author;
import com.example.demo8.domain.Book;
import com.example.demo8.domain.Publisher;
import com.example.demo8.repositories.AuthorRepository;
import com.example.demo8.repositories.BookRepository;
import com.example.demo8.repositories.PublisherRepository;
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
        System.out.println("Started in Bootstrap");

        Author evan = new Author("Evan", "Bacon");
        Book expoBook = new Book("Expo Go", "132");
        Publisher publisher = new Publisher("Pedro", "Del Monte");

        publisherRepository.save(publisher);

        // No entiendo por qué no lo refactoriza
        // a metodos addBook() y addAuthor, dentro de las clases
        evan.getBooks().add(expoBook);
        expoBook.getAuthors().add(evan);

        expoBook.setPublisher(publisher);
        publisher.getBooks().add(expoBook);
//
        // publisherRepository.save(publisher); Si lo pongo en esta linea rompe y no entiendo el por qué
        authorRepository.save(evan);
        bookRepository.save(expoBook);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book tsBook = new Book("Typescript cookbook", "124");

        rod.getBooks().add(tsBook);
        tsBook.getAuthors().add(rod);

        tsBook.setPublisher(publisher);
        publisher.getBooks().add(tsBook);

        authorRepository.save(rod);
        bookRepository.save(tsBook);
        // publisherRepository.save(publisher); // No me funciona si lo agrego aca

        //
        System.out.println("Started in Bootstrap");
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
