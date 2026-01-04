package com.moldavets.library.service.Impl;

import com.moldavets.library.exception.AuthorNotFound;
import com.moldavets.library.mapper.AuthorMapper;
import com.moldavets.library.model.dto.AuthorRequest;
import com.moldavets.library.model.dto.AuthorResponse;
import com.moldavets.library.repository.AuthorRepository;
import com.moldavets.library.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponse getById(Long authorId) {
        var authorEntity = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFound("Entity not found"));
        return AuthorMapper.INSTANCE.map(authorEntity);
    }

    @Override
    public List<AuthorResponse> getAll() {
        return AuthorMapper.INSTANCE.map(authorRepository.findAll());
    }

    @Override
    @Transactional
    public AuthorResponse save(AuthorRequest authorRequest) {
        var savedAuthor = authorRepository.saveAndFlush(AuthorMapper.INSTANCE.map(authorRequest));
        return AuthorMapper.INSTANCE.map(savedAuthor);
    }

    @Override
    @Transactional
    public AuthorResponse update(Long id, AuthorRequest authorRequest) {
        var storedBook = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFound("Entity not found"));
        AuthorMapper.INSTANCE.update(authorRequest, storedBook);
        var updatedAuthorEntity = authorRepository.saveAndFlush(storedBook);
        return AuthorMapper.INSTANCE.map(updatedAuthorEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var storedAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFound("Entity not found"));

        authorRepository.delete(storedAuthor);
    }
}
