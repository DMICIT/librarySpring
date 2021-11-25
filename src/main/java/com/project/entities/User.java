package com.project.entities;

import com.project.enums.Gender;
import com.project.enums.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = "email", name="users_unique_email_idx"))
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private boolean banList;
    @Column
    private String password;

}
