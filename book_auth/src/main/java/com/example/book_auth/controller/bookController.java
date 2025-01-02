package com.example.book_auth.controller;

import com.example.book_auth.dto.BookDto;
import com.example.book_auth.entity.Book;
import com.example.book_auth.repo.BookRepo;
import com.example.book_auth.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class bookController {
@Autowired
    private BookService bookService;
@PostMapping("/createbook")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookdto) {
    BookDto book = bookService.createBook(bookdto);
    return new ResponseEntity<>(book, HttpStatus.CREATED);
}

}
