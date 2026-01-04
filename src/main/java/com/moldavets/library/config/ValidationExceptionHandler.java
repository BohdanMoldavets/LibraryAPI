package com.moldavets.library.config;

import com.moldavets.library.exception.AuthorNotFound;
import com.moldavets.library.exception.BookAuthorNotFound;
import com.moldavets.library.exception.BookNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AuthorNotFound.class)
    public ResponseEntity<Map<String, String>> handleValidation(AuthorNotFound ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BookAuthorNotFound.class)
    public ResponseEntity<Map<String, String>> handleValidation(BookAuthorNotFound ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<Map<String, String>> handleValidation(BookNotFound ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleValidation(EntityNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());
        return ResponseEntity.badRequest().build();
    }

}
