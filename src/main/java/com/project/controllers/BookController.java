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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping(value = "/books")
    public String bookPage(Model model, HttpServletRequest request) {
        String search = request.getParameter("search");
        String sortParam = "id";
        String order = "asc";
        int pageSize = 7;
        int page = 0;

        if (request.getParameter("sort") != null){
            sortParam = request.getParameter("sort");
        }
        if (request.getParameter("order") != null){
            order= request.getParameter("order");
        }

        Sort sort = Sort.by(Sort.Direction.fromString(order), sortParam);

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

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
