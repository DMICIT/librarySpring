package com.project.entities;

import lombok.*;

import javax.persistence.*;

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
    @JoinColumn(name ="user_id")
    private User user;

    @Column(name="penalty_cost")
    private int penaltyCost;


}