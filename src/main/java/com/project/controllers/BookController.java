package com.project.controllers;

import com.project.entities.Book;
import com.project.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class BookController {

    @Resource
    private BookRepository bookRepository;

    @GetMapping(value = "/books")
    public String bookPage(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books",books);
        return "books";
    }

}
