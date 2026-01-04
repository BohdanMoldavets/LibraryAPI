package com.moldavets.library.controller;

import com.moldavets.library.model.dto.BookRequest;
import com.moldavets.library.model.dto.BookResponse;
import com.moldavets.library.service.BookService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll(@PathParam("authorId") Long authorId) {
        return ResponseEntity.ok(Objects.nonNull(authorId) ? bookService.getAll(authorId) : bookService.getAll());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getById(bookId));
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody @Valid BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.save(bookRequest), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponse> update(@PathVariable Long bookId,
                                               @RequestBody @Valid BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.update(bookId, bookRequest), HttpStatusCode.valueOf(204));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();
    }

}
