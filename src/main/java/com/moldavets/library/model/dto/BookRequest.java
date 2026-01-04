package com.moldavets.library.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BookRequest {

    private String id;

    @NotBlank
    private String title;

    @NotBlank
    @Pattern(regexp = "^\\d{1,4}$", message = "Invalid year")
    private String year;

    @Min(0)
    @JsonProperty("authorId")
    private Integer authorId;

}
