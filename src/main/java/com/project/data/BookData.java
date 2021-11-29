package com.project.data;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookData {
    private int id;
    private String author;
    private String bookName;
    private String bookEdition;
    private LocalDate releaseDate;
    private CatalogData catalogData;
}
