package com.moldavets.library.service.Impl;

import com.moldavets.library.mapper.BookMapper;
import com.moldavets.library.model.dto.Book;
import com.moldavets.library.repository.BookRepository;
import com.moldavets.library.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getById(Long bookId) {
        var bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return BookMapper.INSTANCE.map(bookEntity);
    }

    @Override
    public List<Book> getAll() {
        return BookMapper.INSTANCE.map(bookRepository.findAll());
    }

    @Override
    public Book save(Book book) {
        var savedBook = bookRepository.saveAndFlush(BookMapper.INSTANCE.map(book));
        return BookMapper.INSTANCE.map(savedBook);
    }

    @Override
    public Book update(Long id, Book bookEntity) {
        var storedBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        var updatedBookEntity = bookRepository.saveAndFlush(storedBook);
        return BookMapper.INSTANCE.map(updatedBookEntity);
    }

    @Override
    public void delete(Long id) {
        var storedBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        bookRepository.delete(storedBook);
    }
}
