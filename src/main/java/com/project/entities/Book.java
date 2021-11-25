package com.project.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name="books")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String author;
    @Column
    private String bookName;
    @Column
    private String bookEdition;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

}
