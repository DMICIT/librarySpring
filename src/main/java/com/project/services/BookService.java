package com.project.services;

import com.project.data.BookData;
import com.project.data.CatalogData;
import com.project.entities.Book;
import com.project.entities.Catalog;
import com.project.forms.AdminEditBookForm;
import com.project.repositories.BookRepository;
import com.project.repositories.CatalogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Resource
    private CatalogRepository catalogRepository;
    @Resource
    private BookRepository bookRepository;

    public List<BookData> findAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return getBookDataList(allBooks);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public BookData getBookById(int id) {
        Optional<Book> bookById = bookRepository.findById(id);
        return getBookData(bookById.get());
    }


    public void editBook(AdminEditBookForm form) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(form.getReleaseDate(), formatter);

        Book book = new Book();
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
}
