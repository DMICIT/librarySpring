package com.project.forms;

import com.project.enums.Gender;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

    @NotNull
    @Pattern(regexp ="[A-Za-zА-Яа-я0-9- ]*")
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Gender gender;

    @NotNull
    private String phone;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9#?!@$%^&*-]*$")
    @Size(min = 4)
    private String password;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9#?!@$%^&*-]*$")
    @Size(min = 4)
    private String confirmPassword;

}
