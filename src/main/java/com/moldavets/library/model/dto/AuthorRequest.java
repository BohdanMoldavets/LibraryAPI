package com.moldavets.library.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthorRequest {

    private Long id;

    @NotBlank
    @JsonProperty("first_name")
    @Pattern(
            regexp = "^[\\p{L}]+([ '-][\\p{L}]+)*$",
            message = "Invalid last name"
    )
    private String firstName;

    @NotBlank
    @JsonProperty("last_name")
    @Pattern(
            regexp = "^[\\p{L}]+([ '-][\\p{L}]+)*$",
            message = "Invalid last name"
    )
    private String lastName;

}