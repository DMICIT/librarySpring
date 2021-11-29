package com.project.controllers;
import com.project.data.BookData;
import com.project.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping(value = "/books")
    public String bookPage(Model model) {
        List<BookData> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

}
