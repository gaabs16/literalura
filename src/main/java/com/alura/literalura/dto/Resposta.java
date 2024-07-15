package com.alura.literalura.dto;

import com.alura.literalura.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public record Resposta(List<DadosLivro> results) {
}
