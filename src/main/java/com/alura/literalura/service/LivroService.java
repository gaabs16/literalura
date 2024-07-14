package com.alura.literalura.service;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.dto.LivroDTO;
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

//    public List<LivroDTO> buscarLivroPeloTitulo(String titulo) {
//        return this.livroRepository.findByTitulo(titulo)
//                .stream()
//                .map(t -> new LivroDTO(t.id(), t.title(), t.author(), t.language(), t.downloads(),t.birthYear(),t.deathYear()))
//                .collect(Collectors.toList());
//    }

    public void salvarLivro(LivroDTO livro){
        this.livroRepository.save(livro.getEntity());
    }

//    public List<LivroDTO> listarLivrosRegistrados() {
//        return livroRepository.findAll()
//                .stream()
//                .map(l -> new LivroDTO(l.getId(), l.getTitle(), l.getAuthor(), l.getLanguage(), l.getDownloads(),l.getBirthYear(),l.getDearthYear()))
//                .collect(Collectors.toList());
//    }
//
//    public List<AutorDTO> listarAutoresRegistrados() {
//        return autorRepository.findAll()
//                .stream()
//                .map(a -> new AutorDTO(a.getId(), a.getName(), a.getNationality(), a.getBirthYear(), a.getDeathYear()))
//                .collect(Collectors.toList());
//    }
//
//    public List<AutorDTO> listarAutoresVivosEmAno(String ano) {
//        return autorRepository.findAutoresVivosEmAno(ano);
//    }
//
//    public List<LivroDTO> listarLivrosPorIdioma(String language) {
//        return livroRepository.findByIdioma(language);
//    }
//
//    public List<LivroDTO> listarPorLivro (List<Livro> livro) {
//        return livro.stream()
//                .map(l -> new LivroDTO(l.getId(), l.getTitle(), l.getAuthor(), l.getLanguage(), l.getDownloads(),l.getBirthYear(),l.getDearthYear()))
//                .collect(Collectors.toList());
//    }
}

