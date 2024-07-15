package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias("title") String title,
         @JsonAlias("authors") List<DadosAutor> author,
         @JsonAlias("languages") String language,
         @JsonAlias("download_count") double downloads,
        @JsonProperty("results") List<DadosLivro> results
) {}
