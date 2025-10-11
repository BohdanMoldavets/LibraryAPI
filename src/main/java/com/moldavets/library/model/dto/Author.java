package com.moldavets.library.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record Author(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                     @NotBlank String firstName,
                     @NotBlank String lastName) {
}