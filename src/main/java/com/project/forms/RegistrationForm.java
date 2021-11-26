package com.project.forms;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {
    private String name;
    private String email;
    private String sex;
    private String phone;
    private String password;
    private String confirmPassword;

}
