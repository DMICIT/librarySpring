package com.project.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="catalog")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor

public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="book_id")
    private Book book;
    @Column
    private int count;

}
