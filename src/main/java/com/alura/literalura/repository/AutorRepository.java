package com.alura.literalura.repository;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
//    @Query("SELECT a FROM Autor a WHERE a.dataFalecimento IS NULL AND a.dataNascimento < ?1")
//    List<AutorDTO> findAutoresVivosEmAno(String ano);
//
//    @Query("SELECT DISTINCT a.nome FROM Autor a")
//    List<String> findAllAutores();
}
