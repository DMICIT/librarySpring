package com.project.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name="books")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="author")
    private String author;

    @Column(name="book_name")
    private String bookName;

    @Column(name="book_edition")
    private String bookEdition;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

}
