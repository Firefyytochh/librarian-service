package com.example.librarian.service;

import com.example.librarian.model.Book;
import com.example.librarian.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) { this.repo = repo; }

    public List<Book> findAll() { return repo.findAll(); }
    public Optional<Book> findById(Long id) { return repo.findById(id); }
    public Book add(Book book) { return repo.save(book); }
    public void delete(Long id) { repo.deleteById(id); }
    public Book update(Book book) { return repo.save(book); }
}
