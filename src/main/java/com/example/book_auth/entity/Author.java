package com.example.book_auth.entity;
import jakarta.persistence.*;

import java.util.*;

@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>() ;
    public Author() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Author(int id, String name, String email, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.books = books;
    }
}
