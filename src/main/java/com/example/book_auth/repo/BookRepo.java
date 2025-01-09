package com.example.book_auth.repo;
import com.example.book_auth.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {



}
