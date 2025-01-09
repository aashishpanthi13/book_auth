package com.example.book_auth.service;

import com.example.book_auth.dto.BookDto;
import com.example.book_auth.entity.Book;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto getBook(int id);
    List<BookDto> getAllBooks();
    Book updateBook(int id, BookDto bookDto);
    BookDto addAuthorToBook(int bookId, int authorId);
    BookDto removeAuthorFromBook(int bookId, int authorId);
    void deleteBook(int id);
}
