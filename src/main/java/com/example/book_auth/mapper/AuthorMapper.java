package com.example.book_auth.mapper;

import com.example.book_auth.dto.AuthorDto;
import com.example.book_auth.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper{
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDTO);
    List<AuthorDto> toDtoList(List<Author> authors);
}

