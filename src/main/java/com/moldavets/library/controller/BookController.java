package com.moldavets.library.controller;

import com.moldavets.library.model.dto.Book;
import com.moldavets.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getById(bookId));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> update(@PathVariable Long bookId,
                       @RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.update(bookId, book));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();
    }

}
