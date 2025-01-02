package com.example.book_auth.dto;

import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private int id;
    private String title;
    private String email;
    private Set<AuthorDto> authors;
}
