package com.moldavets.library.controller;

import com.moldavets.library.model.dto.Author;
import com.moldavets.library.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> get(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.getById(authorId));
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> update(@PathVariable Long authorId, @RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(authorId, author));
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Author> delete(@PathVariable Long authorId) {
        authorService.delete(authorId);
        return ResponseEntity.noContent().build();
    }
}
