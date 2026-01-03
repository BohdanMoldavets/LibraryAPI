package com.moldavets.library.service.Impl;

import com.moldavets.library.mapper.BookMapper;
import com.moldavets.library.model.dto.AuthorRequest;
import com.moldavets.library.model.dto.BookRequest;
import com.moldavets.library.model.dto.BookResponse;
import com.moldavets.library.model.search.BookSearchRequest;
import com.moldavets.library.model.search.BookSpecificationBuilder;
import com.moldavets.library.repository.AuthorRepository;
import com.moldavets.library.repository.BookRepository;
import com.moldavets.library.service.AuthorService;
import com.moldavets.library.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<BookResponse> search(BookSearchRequest searchRequest) {
        var specification = BookSpecificationBuilder.builder()
                .withIds(searchRequest.getIds())
                .withTitles(searchRequest.getTitles())
                .withProductionDateBetween(searchRequest.getProductionDateFrom(), searchRequest.getProductionDateTo())
                .build();
        return BookMapper.INSTANCE.mapToResponse(bookRepository.findAll(specification));
    }

    @Override
    public BookResponse getById(Long bookId) {
        var bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return BookMapper.INSTANCE.mapToResponse(bookEntity);
    }

    @Override
    public List<BookResponse> getAll() {
        return BookMapper.INSTANCE.mapToResponse(bookRepository.findAll());
    }

    @Override
    @Transactional
    public BookResponse save(BookRequest bookRequest) {
        var authorEntity = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        var mappedBook = BookMapper.INSTANCE.map(bookRequest);
        mappedBook.setAuthor(authorEntity);
        var savedBook = bookRepository.saveAndFlush(mappedBook);
        return BookMapper.INSTANCE.mapToResponse(savedBook);
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest bookRequestEntity) {
        var storedBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        var updatedBookEntity = bookRepository.saveAndFlush(storedBook);
        return BookMapper.INSTANCE.mapToResponse(updatedBookEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var storedBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        bookRepository.delete(storedBook);
    }
}
