package com.example.book_auth.serviceimpl;
import com.example.book_auth.dto.AuthorDto;
import com.example.book_auth.entity.Author;
import com.example.book_auth.mapper.AuthorMapper;
import com.example.book_auth.repo.AuthorRepo;
import com.example.book_auth.repo.BookRepo;
import com.example.book_auth.service.AuthorService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;
    private final  AuthorMapper authorMapper;
    private BookRepo bookRepo;
    private  AuthorService authorService;

    public AuthorServiceImpl(@Lazy AuthorRepo authorRepo, @Lazy AuthorService authorService, AuthorMapper authorMapper) {
        this.authorRepo = authorRepo;
        this.authorService = authorService;
        this.authorMapper = authorMapper;

    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        return authorMapper.toDto(authorRepo.save(author));
    }

    @Override
    public AuthorDto getAuthor(int id) {
        return authorRepo.findById(id)
                .map(authorMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorMapper.toDtoList(authorRepo.findAll());
    }

    @Override
    public AuthorDto updateAuthor(int id, AuthorDto authorDto) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());
        return authorMapper.toDto(authorRepo.save(author));
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepo.deleteById(id);

    }
}
