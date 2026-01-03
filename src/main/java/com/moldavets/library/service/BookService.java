package com.moldavets.library.service;

import com.moldavets.library.model.dto.BookRequest;
import com.moldavets.library.model.dto.BookResponse;
import com.moldavets.library.model.search.BookSearchRequest;

import java.util.List;

public interface BookService extends CrudService<BookRequest, BookResponse> {

    List<BookResponse> search(BookSearchRequest searchRequest);

}
