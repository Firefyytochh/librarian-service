package com.example.librarian.controller;

import com.example.librarian.model.Book;
import com.example.librarian.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class LibrarianController {
    private final BookService service;
    public LibrarianController(BookService service) { this.service = service; }

    // List all books
    @GetMapping("/books")
    public List<Book> allBooks() {
        return service.findAll();
    }

    // Get single book
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book saved = service.add(book);
        return ResponseEntity.created(URI.create("/dashboard/books/" + saved.getId())).body(saved);
    }

    // Update (for example: mark available/unavailable)
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return service.findById(id).map(existing -> {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setAvailable(book.isAvailable());
            Book updated = service.update(existing);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
