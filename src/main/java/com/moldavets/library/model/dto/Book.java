package com.moldavets.library.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record Book(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                   @NotBlank String title,
                   LocalDate productionDate,
                   Author author) {
}
