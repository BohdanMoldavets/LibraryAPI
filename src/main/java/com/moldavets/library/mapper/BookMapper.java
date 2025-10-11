package com.moldavets.library.mapper;

import com.moldavets.library.model.BookEntity;
import com.moldavets.library.model.dto.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookEntity map(Book book);
    Book map(BookEntity bookEntity);
    List<Book> map (List<BookEntity> bookEntity);
}
