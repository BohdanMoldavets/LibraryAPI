package com.moldavets.library.service;

import com.moldavets.library.model.dto.Book;
import com.moldavets.library.model.search.BookSearchRequest;

import java.util.List;

public interface BookService extends CrudService<Book> {

    List<Book> search(BookSearchRequest searchRequest);

}
