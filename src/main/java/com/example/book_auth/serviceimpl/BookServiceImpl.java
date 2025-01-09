package com.example.book_auth.serviceimpl;
import com.example.book_auth.dto.BookDto;
import com.example.book_auth.entity.Author;
import com.example.book_auth.entity.Book;
import com.example.book_auth.mapper.BookMapper;
import com.example.book_auth.repo.AuthorRepo;
import com.example.book_auth.repo.BookRepo;
import com.example.book_auth.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepo authorRepo;
   private final BookRepo bookRepo;
   private final BookService bookService;
   private final BookMapper bookMapper;


    public BookServiceImpl( @Lazy BookRepo bookRepo, @Lazy BookService bookService, BookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.bookService = bookService;
        this.bookMapper = bookMapper;


    }


    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        //System.out.println(book.getId());
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
        return bookRepo.findById(id).map(book -> {
            book.setTitle(bookDto.getTitle());
            return (bookRepo.save(book));
        }).orElseThrow(() -> new RuntimeException("Book not found"));

    }



    @Override
    public BookDto addAuthorToBook(int bookId, int authorId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.getAuthors().add(author);
        return bookMapper.toDto(bookRepo.save(book));
    }

    @Override
    public BookDto removeAuthorFromBook(int bookId, int authorId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        book.getAuthors().remove(author);
        return bookMapper.toDto(bookRepo.save(book));
    }

    @Override
    public void deleteBook(int id) {
      bookRepo.deleteById(id);
    }



}
