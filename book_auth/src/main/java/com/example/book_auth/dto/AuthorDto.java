package com.example.book_auth.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorDto {
    private int id;
    private String name;
    private String email;
}
