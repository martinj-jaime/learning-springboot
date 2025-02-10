package com.example.demo8.repositories;

import com.example.demo8.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {




}
