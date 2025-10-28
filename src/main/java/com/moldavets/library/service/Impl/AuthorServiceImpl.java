package com.moldavets.library.service.Impl;

import com.moldavets.library.mapper.AuthorMapper;
import com.moldavets.library.model.dto.Author;
import com.moldavets.library.repository.AuthorRepository;
import com.moldavets.library.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author getById(Long authorId) {
        var authorEntity = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return AuthorMapper.INSTANCE.map(authorEntity);
    }

    @Override
    public List<Author> getAll() {
        return AuthorMapper.INSTANCE.map(authorRepository.findAll());
    }

    @Override
    public Author save(Author author) {
        var savedAuthor = authorRepository.saveAndFlush(AuthorMapper.INSTANCE.map(author));
        return AuthorMapper.INSTANCE.map(savedAuthor);
    }

    @Override
    public Author update(Long id, Author object) {
        var storedBook = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        var updatedAuthorEntity = authorRepository.saveAndFlush(storedBook);
        return AuthorMapper.INSTANCE.map(updatedAuthorEntity);
    }

    @Override
    public void delete(Long id) {
        var storedAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        authorRepository.delete(storedAuthor);
    }
}
