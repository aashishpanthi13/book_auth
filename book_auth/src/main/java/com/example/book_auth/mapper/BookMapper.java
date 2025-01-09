package com.example.book_auth.mapper;

import com.example.book_auth.dto.BookDto;
import com.example.book_auth.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDTO);
    List<BookDto> toDtoList(List<Book> books);
}
