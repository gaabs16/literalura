package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias("title") String title,
        @JsonAlias("languages") List<String> language,
         @JsonAlias("download_count") int downloads,
         @JsonAlias("authors") List<DadosAutor> author
) {}
