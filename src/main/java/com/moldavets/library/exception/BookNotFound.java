package com.moldavets.library.exception;

import jakarta.persistence.EntityNotFoundException;

public class BookNotFound extends EntityNotFoundException {
    public BookNotFound(String message) {
        super(message);
    }
}
