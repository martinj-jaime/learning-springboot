package com.example.demo8.repositories;

import com.example.demo8.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
