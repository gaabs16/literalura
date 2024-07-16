package com.alura.literalura.service;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void salvarLivro(Livro livro){
        this.livroRepository.save(livro);
        System.out.println(livro.toString());
        System.out.println("livro foi salvo");
    }

    public List<LivroDTO> listarLivrosRegistrados() {
        return livroRepository.findAll()
                .stream()
                .map(l -> new LivroDTO(l.getTitle(), l.getAuthor(), l.getLanguage(), l.getDownloads()))
                .collect(Collectors.toList());
    }

    public List<AutorDTO> listarAutoresRegistrados() {
        return autorRepository.findAll()
                .stream()
                .map(a -> new AutorDTO(a.getName(),a.getBirthYear(), a.getDeathYear()))
                .collect(Collectors.toList());
    }


    public List<AutorDTO> listarAutoresVivosEmAno(Integer ano) {
        return autorRepository.findAutoresVivosEmAno(ano)
                .stream()
                .map(a -> new AutorDTO(a.getName(),a.getBirthYear(), a.getDeathYear()))
                .collect(Collectors.toList());
    }

    public List<LivroDTO> listarLivrosPorIdioma(String language) {
        return livroRepository.findByIdioma(language)
                .stream()
                .map(l -> new LivroDTO(l.getTitle(), l.getAuthor(), l.getLanguage(), l.getDownloads()))
                .collect(Collectors.toList());
    }
}

