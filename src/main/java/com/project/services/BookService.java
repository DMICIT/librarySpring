package com.project.services;

import com.project.entities.Book;
import com.project.entities.Catalog;
import com.project.forms.AdminEditBookForm;
import com.project.repositories.BookRepository;
import com.project.repositories.CatalogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Resource
    private CatalogRepository catalogRepository;
    @Resource
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public Book getBookById(int id) {
        Optional<Book> bookById = bookRepository.findById(id);
        return bookById.get();
    }

    public void editBook(AdminEditBookForm form) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse(form.getReliaseDate(), formatter);

        Book book = new Book(form.getBookId(), form.getAuthor(), form.getBookName(), form.getBookEdition(), date);
        bookRepository.save(book);

        Catalog catalogByBookId = catalogRepository.findCatalogByBookId(form.getBookId());
        if (catalogByBookId == null) {
            catalogByBookId = new Catalog();
            catalogByBookId.setBook(book);
        }
        catalogByBookId.setCount(form.getCount());
        catalogRepository.save(catalogByBookId);
    }

}
