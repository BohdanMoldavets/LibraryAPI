package com.moldavets.library.controller;

import com.moldavets.library.model.dto.Book;
import com.moldavets.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable Long bookId) {
        return bookService.getById(bookId);
    }

    @PostMapping
    public Book create(@RequestBody @Valid Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{bookId}")
    public Book update(@PathVariable Long bookId,
                       @RequestBody @Valid Book book) {
        return bookService.update(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
    }

}
