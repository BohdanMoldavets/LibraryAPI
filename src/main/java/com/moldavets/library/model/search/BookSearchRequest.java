package com.moldavets.library.model.search;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookSearchRequest {
    private List<Long> ids;
    private List<String> titles;
    private Integer yearFrom;
    private Integer yearTo;
}
