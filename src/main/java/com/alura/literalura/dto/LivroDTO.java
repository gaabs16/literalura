package com.alura.literalura.dto;

import com.alura.literalura.model.Livro;

public record LivroDTO (Long id, String title, String author, String language, double downloads, String birthYear, String deathYear){
    public Livro getEntity(){
        Livro livro = new Livro();
        livro.setId(id);
        livro.setTitle(title);
        livro.setAuthor(author);
        livro.setLanguage(language);
        livro.setDownloads(downloads);
        livro.setBirthYear(birthYear);
        livro.setDearthYear(deathYear);
        return livro;
    }

    public void setEntity(LivroDTO dados){

    }

}