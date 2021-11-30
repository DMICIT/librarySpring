package com.project.controllers;

import com.project.data.BookData;
import com.project.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping(value = "/books")
    public String bookPage(Model model,
                           @RequestParam (required = false) String search,
                           @RequestParam(defaultValue = "id", name = "sort")String sortParam,
                           @RequestParam(defaultValue = "asc") String order,
                           @RequestParam(defaultValue = "7", name = "pageSize") Integer pageSize,
                           @RequestParam(defaultValue = "0", name = "page") Integer page) {


        Sort sort = Sort.by(Sort.Direction.fromString(order), sortParam);
        Pageable pageable = PageRequest.of(page, pageSize ,sort);
        Page<BookData> bookDataPage;

        if (search != null) {
            bookDataPage = bookService.findAllBooks(search,pageable);
        } else {
            bookDataPage = bookService.findAllBooks(pageable);
        }
        model.addAttribute("booksData", bookDataPage);
        return "books";
    }


}
