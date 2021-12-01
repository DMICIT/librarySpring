package com.project.controllers;

import com.project.data.BookData;
import com.project.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;
    @Mock
    private Model model;
    @Mock
    private Pageable pageable;
    @Mock
    private Page<BookData> bookDataPage;

    @Test
    void testGetBookPageSearchNull() {

        when(bookService.findAllBooks(any(Pageable.class))).thenReturn(bookDataPage);
        String result = bookController.bookPage(model, null, "id", "asc", 5, 1);

        assertEquals("books", result);
        verify(bookService).findAllBooks(any(Pageable.class));
        verify(model).addAttribute("booksData",bookDataPage);

    }

    @Test
    void testGtBookPageSearchNotNull() {

        when(bookService.findAllBooks(eq("someText"), any(Pageable.class))).thenReturn(bookDataPage);

        String result = bookController.bookPage(model, "someText", "id", "asc", 5, 1);

        assertEquals("books",result);
        verify(model).addAttribute("booksData", bookDataPage);


    }
}