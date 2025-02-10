package com.example.demo8.controllers;

import com.example.demo8.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", this.authorRepository.findAll());
        return "authors/list";
    }
}
