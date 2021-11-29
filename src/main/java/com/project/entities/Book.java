package com.project.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


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

    @OneToOne(mappedBy = "book", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Catalog catalog;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orderList;

}
