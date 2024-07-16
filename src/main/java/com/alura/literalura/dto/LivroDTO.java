package com.alura.literalura.dto;

import com.alura.literalura.model.Autor;

public record LivroDTO (String title, Autor author, String language , int downloads){
}