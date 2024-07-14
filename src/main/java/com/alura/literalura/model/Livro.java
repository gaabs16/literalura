package com.alura.literalura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Livro {
    @Id
    private Long id;
    private String title;
    private String author;
    private String language;
    private Double downloads;
    private String birthYear;
    private String deathYear;

    @ElementCollection
    private List<String> subjects;

    @ElementCollection
    private List<String> languages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Autor> autor;

    @ElementCollection
    @CollectionTable(name = "book_languages", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "language")
    private List<String> translators;

    @ElementCollection
    @MapKeyColumn(name="format")
    @Column(name="url")
    @CollectionTable(name="book_format", joinColumns=@JoinColumn(name="book_id"))
    private Map<String, String> formats;
}
