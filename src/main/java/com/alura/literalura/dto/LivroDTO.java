package com.alura.literalura.dto;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DadosAutor;
import com.alura.literalura.model.Livro;

public record LivroDTO (Long id, String title, DadosAutor author, String language , int downloads, String birthYear, String deathYear){
    public Livro getEntity(){
        Livro livro = new Livro();
        livro.setId(id);
        livro.setTitle(title);
        livro.setAuthor(new Autor(author()));
        livro.setLanguage(language);
        livro.setDownloads(downloads);
        return livro;
    }

    public void setEntity(LivroDTO dados){

    }

}