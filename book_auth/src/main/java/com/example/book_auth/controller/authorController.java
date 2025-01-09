package com.example.book_auth.controller;
import com.example.book_auth.dto.AuthorDto;
import com.example.book_auth.mapper.AuthorMapper;
import com.example.book_auth.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class authorController {
 @Autowired
 private AuthorService authorService;
 @Autowired
 private AuthorMapper authorMapper;
    @PostMapping("/createAuthor")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto authorDto1 = authorService.createAuthor(authorDto);
        return new  ResponseEntity<>(authorDto1, HttpStatus.CREATED);
    }
    @GetMapping("/{id}/getAuthorById")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable int id) {
        AuthorDto authorDto1 = authorService.getAuthor(id);
        return new ResponseEntity<>(authorDto1, HttpStatus.OK);

    }
    @GetMapping("/getAllAuthors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> authorDtos1 = authorService.getAllAuthors();
        return new ResponseEntity<>(authorDtos1, HttpStatus.OK);
    }
    @PutMapping("{id}/updateAuthor")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable int id, @RequestBody AuthorDto authorDto) {
        AuthorDto authorDto1 = authorService.updateAuthor(id, authorDto);
        return new ResponseEntity<>(authorDto1, HttpStatus.OK);

    }
    @DeleteMapping("{id}/deleteAuthorById")
public ResponseEntity<AuthorDto> deleteAuthorById(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();

    }

}
