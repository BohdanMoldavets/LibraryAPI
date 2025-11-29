package com.moldavets.library.model.search;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookSearchRequest {
    private List<Long> ids;
    private List<String> titles;
    private LocalDate productionDateFrom;
    private LocalDate productionDateTo;
}
