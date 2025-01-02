package com.example.book_auth.repo;

import com.example.book_auth.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
