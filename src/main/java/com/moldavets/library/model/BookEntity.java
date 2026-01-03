package com.moldavets.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOOKS")
@ToString(exclude = "author")
@EqualsAndHashCode
public class BookEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRODUCTION_DATE")
    private LocalDate productionDate;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private AuthorEntity author;

}

