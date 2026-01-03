package com.moldavets.library.mapper;

import com.moldavets.library.model.BookEntity;
import com.moldavets.library.model.dto.BookRequest;
import com.moldavets.library.model.dto.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookEntity map(BookRequest bookRequest);
    BookRequest map(BookEntity bookEntity);
    List<BookRequest> map (List<BookEntity> bookEntity);
    BookResponse mapToResponse(BookEntity bookEntity);

    List<BookResponse> mapToResponse(List<BookEntity> bookEntities);
}
