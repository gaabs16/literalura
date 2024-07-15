package com.alura.literalura.repository;

import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
//    @Query("SELECT t from title where t.title ILIKE %:titulo%")
//    List<LivroDTO> findByTitulo(String titulo);
}
