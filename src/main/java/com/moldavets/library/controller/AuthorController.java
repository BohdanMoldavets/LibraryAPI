package com.moldavets.library.controller;

import com.moldavets.library.model.dto.AuthorRequest;
import com.moldavets.library.model.dto.AuthorResponse;
import com.moldavets.library.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
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
        return new ResponseEntity<>(authorService.save(authorRequest), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long authorId, @RequestBody @Valid AuthorRequest authorRequest) {
        return new ResponseEntity<>(authorService.update(authorId, authorRequest), HttpStatusCode.valueOf(204));
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<AuthorResponse> delete(@PathVariable Long authorId) {
        authorService.delete(authorId);
        return ResponseEntity.noContent().build();
    }
}
