package com.alura.literalura.service;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final GutenApi gutenApi = new GutenApi();

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LivroDTO> buscarLivroPeloTitulo(String titulo) {
        LivroDTO livroDTO = this.gutenApi.obterDados(titulo);
        return livroDTO;
    }

    public List<LivroDTO> listarLivrosRegistrados() {
        return livroRepository.findAll()
                .stream()
                .map(l -> new LivroDTO(l.getId(), l.getTitle(), l.getAuthor(), l.getLanguage(), l.getDownloads(),l.getBirthYear(),l.getDeathYear()))
                .collect(Collectors.toList());
    }

    public List<AutorDTO> listarAutoresRegistrados() {
        return autorRepository.findAll()
                .stream()
                .map(a -> new AutorDTO(a.getId(), a.getName(), a.getNationality(), a.getBirthYear(), a.getDeathYear()))
                .collect(Collectors.toList());
    }

    public List<AutorDTO> listarAutoresVivosEmAno(String ano) {
        return autorRepository.findAutoresVivosEmAno(ano);
    }

    public List<LivroDTO> listarLivrosPorIdioma(String language) {
        return livroRepository.findByIdioma(language);
    }

    public List<LivroDTO> listarPorLivro (List<Livro> livro) {
        return livro.stream()
                .map(l -> new LivroDTO(l.getId(), l.getTitle(), l.getAuthor(), l.getLanguage(), l.getDownloads(),l.getBirthYear(),l.getDeathYear()))
                .collect(Collectors.toList());
    }
}

