package com.project.entities;

import com.project.enums.BookSpot;
import com.project.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="orders")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    private BookSpot bookSpot;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "DATE")
    private LocalDate returnDate;
    @Column
    private String penalty;


}
