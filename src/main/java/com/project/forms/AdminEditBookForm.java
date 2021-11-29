package com.project.forms;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class AdminEditBookForm {

    private int bookId = 0;

    @NotNull
    @Pattern(regexp ="[A-Za-zА-Яа-я0-9.,()!?' -]*")
    private String author;

    @NotNull
    @Pattern(regexp = "[A-Za-zА-Яа-я0-9_.,()!?' -]*")
    private String bookName;

    @NotNull
    @Pattern(regexp = "[A-Za-zА-Яа-я0-9#?!@$%^&* -]*")
    private String bookEdition;

    @NotNull
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
    private String releaseDate;

    private int count;

}
