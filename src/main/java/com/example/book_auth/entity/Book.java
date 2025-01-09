package com.example.book_auth.entity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String title;
       @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Book() {

    }



    public Book(int id, String title, String email, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }
}



