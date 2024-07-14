package com.alura.literalura.repository;

import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT l.titulo, l.autor.nome, l.idioma) FROM Livro l WHERE l.titulo = ?1")
    List<LivroDTO> findByTitulo();

    @Query("SELECT l.titulo, l.autor.nome, l.idioma FROM Livro l")
    List<LivroDTO> findAllLivros();

    @Query("SELECT l.titulo, l.autor.nome, l.idioma FROM Livro l WHERE l.idioma = ?1")
    List<LivroDTO> findByIdioma(String idioma);
}
