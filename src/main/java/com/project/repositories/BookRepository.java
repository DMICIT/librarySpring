package com.project.repositories;

import com.project.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

     Page<Book> findByAuthorContainsOrBookNameContains(String author, String bookName, Pageable pageable);


}
