package com.alura.literalura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String language;

    @Column
    private double downloads;

    @Column
    private String birthYear;

    @Column
    private String dearthYear;

    public Livro(DadosLivro dados) {
        this.title = dados.title();
        this.language = String.join(",", dados.language());
        this.downloads = dados.downloads();
        this.author = dados.author();
    }
}
