package com.moldavets.library.controller;

import com.moldavets.library.model.dto.BookRequest;
import com.moldavets.library.model.dto.BookResponse;
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
    public ResponseEntity<List<BookResponse>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getById(bookId));
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody @Valid BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.save(bookRequest));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponse> update(@PathVariable Long bookId,
                                              @RequestBody @Valid BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.update(bookId, bookRequest));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();
    }

}
