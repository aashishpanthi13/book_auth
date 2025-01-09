package com.example.book_auth.controller;

import com.example.book_auth.dto.BookDto;
import com.example.book_auth.mapper.BookMapper;
import com.example.book_auth.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class bookController {
@Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMapper;


    @PostMapping("/createbook")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookdto) {
    BookDto book = bookService.createBook(bookdto);
    return new ResponseEntity<>(book, HttpStatus.CREATED);
}
@GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id) {
    BookDto book = bookService.getBook(id);
    return new ResponseEntity<>(book, HttpStatus.OK);

}
@GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
    List<BookDto> books = bookService.getAllBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
}

@PutMapping("/{id}/updateBook")
public ResponseEntity<BookDto> updateBook(
        @PathVariable int id, @RequestBody BookDto bookDto) {
    return ResponseEntity.ok(bookMapper.toDto(bookService.updateBook(id, bookDto)));
}
@DeleteMapping("/{id}/deleteBook")
    public ResponseEntity<BookDto> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();

}
    @PutMapping("/{bookId}/{authorId}/addAuthorToBook")
    public ResponseEntity<BookDto> addAuthorToBook(
            @PathVariable int bookId,
            @PathVariable int authorId) {
        return ResponseEntity.ok(bookService.addAuthorToBook(bookId, authorId));
    }
    @DeleteMapping("{bookId}/{authorId}/deleteAuthorFromBooks")
    public ResponseEntity<BookDto> removeAuthorFromBook(@PathVariable int bookId, @PathVariable int authorId) {
        return ResponseEntity.ok(bookService.removeAuthorFromBook(bookId, authorId));
    }



}
