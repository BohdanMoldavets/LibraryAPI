package com.moldavets.library.model.search;

import com.moldavets.library.model.BookEntity;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class BookSpecificationBuilder {

    private Specification<BookEntity> spec;

    public static BookSpecificationBuilder builder() {
        return new BookSpecificationBuilder();
    }

    public BookSpecificationBuilder withIds(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            spec = spec.and(((root, query, criteriaBuilder) ->
                root.get("ID").in(ids)
            ));
        }
        return this;
    }

    public BookSpecificationBuilder withTitles(List<String> titles) {
        if (!CollectionUtils.isEmpty(titles)) {
            spec = spec.and(((root, query, cb) ->
                    root.get("TITLE").in(titles)
            ));
        }
        return this;
    }

    public BookSpecificationBuilder withYearBetween(Integer from, Integer to) {
        if (Objects.nonNull(from) && Objects.nonNull(to)) {
            spec = spec.and((root, query, cb) ->
                    cb.between(root.get("PRODUCTION_YEAR"), from, to));
        } else if (Objects.nonNull(from)) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(root.get("PRODUCTION_YEAR"), from));
        } else if (Objects.nonNull(to)) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(root.get("PRODUCTION_YEAR"), to));
        }
        return this;
    }

    public BookSpecificationBuilder withAuthorId(Long authorId) {
        if (Objects.nonNull(authorId)) {
            Specification<BookEntity> s = (root, query, criteriaBuilder) ->
                    root.get("author").get("id").in(List.of(authorId));
            addSpec(s);
        }
        return this;
    }

    private void addSpec(Specification<BookEntity> toAdd) {
        if (toAdd == null) {
            return;
        }
        spec = (spec == null) ? toAdd : spec.and(toAdd);
    }

    public Specification<BookEntity> build() {
        return spec;
    }

}
