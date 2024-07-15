package com.alura.literalura.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthYear;
    private String deathYear;

    public Autor(DadosAutor dados) {
        this.name = String.join(",", dados.name());
        this.birthYear = dados.birthYear();
        this.deathYear = dados.deathYear();
    }
}
