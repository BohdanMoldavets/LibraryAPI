package com.moldavets.library.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record Book(Long id,
                   @NotBlank String title,
                   LocalDate productionDate,
                   Author author) {
}
