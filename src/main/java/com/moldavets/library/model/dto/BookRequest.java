package com.moldavets.library.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequest {

    private Long id;

    @NotBlank
    private String title;

    private LocalDate productionDate;

    private Long authorId;

}
