package com.project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="penalties")
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor

public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private int penaltyCost;


}