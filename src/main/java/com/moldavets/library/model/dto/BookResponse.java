package com.moldavets.library.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookResponse {

    private Long id;

    @NotBlank
    private String title;

    private LocalDate productionDate;

    private AuthorResponse author;

}
