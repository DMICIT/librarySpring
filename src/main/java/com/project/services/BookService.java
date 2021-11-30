package com.project.services;

import com.project.data.BookData;
import com.project.data.CatalogData;
import com.project.entities.Book;
import com.project.entities.Catalog;
import com.project.forms.AdminEditBookForm;
import com.project.repositories.BookRepository;
import com.project.repositories.CatalogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Resource
    private CatalogRepository catalogRepository;
    @Resource
    private BookRepository bookRepository;

    public Page<BookData> findAllBooks(Pageable pageable) {
        Page<Book> pageForAllBooks = bookRepository.findAll(pageable);
        Page<BookData> bookDataPage = pageForAllBooks.map(this::getBookData);
        return  bookDataPage;
    }

    public Page<BookData> findAllBooks(String search, Pageable pageable) {
        Page<Book> allBooks = bookRepository.findByAuthorContainsOrBookNameContains(search,search, pageable);
        Page<BookData> allDataPage = allBooks.map(this::getBookData);
        return allDataPage;
    }


    private List<BookData> getBookDataList(List<Book> books) {
        List<BookData> result = new ArrayList<>();
        for (Book book : books) {
            BookData bookData = getBookData(book);
            result.add(bookData);
        }
        return result;
    }

    private BookData getBookData(Book book) {

        Catalog catalogByBookId = catalogRepository.findCatalogByBookId(book.getId());
        CatalogData catalogData = new CatalogData();
        if (catalogByBookId != null) {
            catalogData.setTotalQuantity(catalogByBookId.getCount());
        }
        return new BookData(book.getId(), book.getAuthor(), book.getBookName(), book.getBookEdition(), book.getReleaseDate(), catalogData);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public BookData getBookById(int id) {
        Book bookById = bookRepository.getById(id);
        return getBookData(bookById);
    }


    public void editBook(AdminEditBookForm form) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(form.getReleaseDate(), formatter);
        Book book;

        if (form.getBookId()!= 0){
            book = bookRepository.getById(form.getBookId());
        }else{
            book = new Book();
        }
        book.setId(form.getBookId());
        book.setBookEdition(form.getBookEdition());
        book.setBookName(form.getBookName());
        book.setAuthor(form.getAuthor());
        book.setReleaseDate(date);
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
