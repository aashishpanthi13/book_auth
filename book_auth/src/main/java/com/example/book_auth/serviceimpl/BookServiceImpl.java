package com.example.book_auth.serviceimpl;
import com.example.book_auth.dto.BookDto;
import com.example.book_auth.entity.Author;
import com.example.book_auth.entity.Book;
import com.example.book_auth.mapper.BookMapper;
import com.example.book_auth.repo.AuthorRepo;
import com.example.book_auth.repo.BookRepo;
import com.example.book_auth.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
   private BookRepo bookRepo;
   private BookService bookService;
   private BookMapper bookMapper;
   private AuthorRepo authorRepo;


    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        return bookMapper.toDto(bookRepo.save(book));
    }

    @Override
    public BookDto getBook(int id) {
        return bookRepo.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookMapper.toDtoList(bookRepo.findAll());
    }

    @Override
    public Book updateBook(int id, BookDto bookDto) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteById(id);


    }

    @Override
    public BookDto addAuthorToBook(int bookId, int authorId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        System.out.println("book for test ---------"+book);
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
//        book.getAuthors().add(author);
        book.getAuthors().add(author);
        return bookMapper.toDto(bookRepo.save(book));
    }
}
