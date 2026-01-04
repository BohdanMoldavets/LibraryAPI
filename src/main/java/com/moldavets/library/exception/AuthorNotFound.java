package com.moldavets.library.exception;

import jakarta.persistence.EntityNotFoundException;

public class AuthorNotFound extends EntityNotFoundException {
    public AuthorNotFound(String message) {
        super(message);
    }
}
