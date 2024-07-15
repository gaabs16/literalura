package com.alura.literalura.model;

import com.alura.literalura.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToOne
    private Autor author;
    private String language;
    private int downloads;

    public Livro(){}

    public Livro(DadosLivro dados) {
        this.title = dados.title();
        this.language = dados.language().getFirst().toLowerCase();
        this.downloads = dados.downloads();
        this.author = new Autor(dados.author().get(0));
    }
}
