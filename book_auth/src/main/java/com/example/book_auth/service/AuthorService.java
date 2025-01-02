package com.example.book_auth.service;

import com.example.book_auth.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto getAuthor(int id);
    List<AuthorDto> getAllAuthors();
    AuthorDto updateAuthor(int id, AuthorDto authorDto);
    void deleteAuthor(int id);
}
