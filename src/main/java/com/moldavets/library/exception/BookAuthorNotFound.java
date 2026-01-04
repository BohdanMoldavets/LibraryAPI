package com.moldavets.library.exception;

import jakarta.persistence.EntityNotFoundException;

public class BookAuthorNotFound extends EntityNotFoundException {
    public BookAuthorNotFound(String message) {
        super(message);
    }
}
