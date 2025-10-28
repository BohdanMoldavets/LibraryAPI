package com.moldavets.library.mapper;

import com.moldavets.library.model.AuthorEntity;
import com.moldavets.library.model.dto.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author map(AuthorEntity authorEntity);
    AuthorEntity map(Author author);
    List<Author> map(List<AuthorEntity> authorEntities);
}
