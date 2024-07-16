package com.alura.literalura.repository;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE :ano > CAST(a.birthYear AS INTEGER) AND :ano <= CAST(a.deathYear AS INTEGER)")
    List<Autor> findAutoresVivosEmAno(Integer ano);
}
