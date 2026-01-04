package com.moldavets.library.mapper;

import com.moldavets.library.model.AuthorEntity;
import com.moldavets.library.model.dto.AuthorRequest;
import com.moldavets.library.model.dto.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorResponse map(AuthorEntity authorEntity);
    AuthorEntity map(AuthorRequest authorRequest);
    List<AuthorResponse> map(List<AuthorEntity> authorEntities);
    void update(AuthorRequest authorRequest, @MappingTarget AuthorEntity authorEntity);
}
