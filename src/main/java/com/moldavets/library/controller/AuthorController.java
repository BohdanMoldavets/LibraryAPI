package com.moldavets.library.controller;

import com.moldavets.library.model.dto.AuthorRequest;
import com.moldavets.library.model.dto.AuthorResponse;
import com.moldavets.library.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorResponse> get(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.getById(authorId));
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody @Valid AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.save(authorRequest));
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long authorId, @RequestBody @Valid AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.update(authorId, authorRequest));
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<AuthorResponse> delete(@PathVariable Long authorId) {
        authorService.delete(authorId);
        return ResponseEntity.noContent().build();
    }
}
