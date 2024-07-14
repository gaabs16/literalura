package com.alura.literalura.principal;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.service.ConverteDados;
import com.alura.literalura.service.GutenApi;
import com.alura.literalura.service.LivroService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private LivroService livroService;
    private Scanner leitura = new Scanner(System.in);
    private final GutenApi gutenApi = new GutenApi();
    private ConverteDados conversor = new ConverteDados();

    public Principal(LivroService livroService) {
        this.livroService = livroService;
    }

    public void exibeMenu() throws IOException, InterruptedException{
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1- buscar livro pelo título
                    2- listar livros registrados
                    3- listar autores registrados
                    4- listar autores vivos em um determinado ano
                    5- listar livros em um determinado idioma
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
//                case 2:
//                    listarLivrosRegistrados();
//                    break;
//                case 3:
//                    listarAutoresRegistrados();
//                    break;
//                case 4:
//                    listarAutoresVivosEmAno();
//                    break;
//                case 5:
//                    listarLivrosPorIdioma();
//                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void buscarLivroPeloTitulo() throws IOException, InterruptedException {
        System.out.print("Digite o título do livro: ");
        String titulo = leitura.nextLine();
        String modifiedTitle = titulo.replace(" ", "+");
        String response = this.gutenApi.obterDados(modifiedTitle);
        LivroDTO dados = conversor.obterDados(response, LivroDTO.class);
        this.salvarLivro(dados);
    }

//    private void buscarLivroPeloTituloDoBanco() {
//        System.out.print("Digite o título do livro: ");
//        String titulo = leitura.nextLine();
//        String modifiedTitle = titulo.replace(" ", "+");
//        this.livroService.buscarLivroPeloTitulo(modifiedTitle);
//        List<LivroDTO> livros = livroService.buscarLivroPeloTitulo(titulo);
//        if (livros.isEmpty()) {
//            System.out.println("Nenhum livro encontrado com o título: " + titulo);
//        } else {
//            System.out.println("Livros encontrados:");
//            livros.forEach(livro -> {
//                System.out.println("Título: " + livro.title() +
//                        ", Autor: " + livro.author() +
//                        ", Idioma: " + livro.language());
//            });
//        }
//    }

    private void salvarLivro(LivroDTO salva) {
         livroService.salvarLivro(salva);
    }

//    private void listarLivrosRegistrados() {
//        List<LivroDTO> livros = livroService.listarLivrosRegistrados();
//        if (livros.isEmpty()) {
//            System.out.println("Nenhum livro registrado.");
//        } else {
//            System.out.println("Livros registrados:");
//            livros.forEach(livro -> {
//                System.out.println("Título: " + livro.title() +
//                        ", Autor: " + livro.author() +
//                        ", Idioma: " + livro.language());
//            });
//        }
//    }
//
//    private void listarAutoresRegistrados() {
//        List<AutorDTO> autores = livroService.listarAutoresRegistrados();
//        if (autores.isEmpty()) {
//            System.out.println("Nenhum autor registrado.");
//        } else {
//            System.out.println("Autores registrados:");
//            autores.forEach(autor -> {
//                System.out.println("Nome: " + autor.name() +
//                        ", Nacionalidade: " + autor.nationality() +
//                        ", Data de Nascimento: " + autor.birthYear() +
//                        ", Data de Falecimento: " + autor.deathYear());
//            });
//        }
//    }
//
//    private void listarAutoresVivosEmAno() {
//        System.out.print("Digite o ano: ");
//        String ano = leitura.nextLine();
//        List<AutorDTO> autores = livroService.listarAutoresVivosEmAno(ano);
//        if (autores.isEmpty()) {
//            System.out.println("Nenhum autor encontrado vivo no ano: " + ano);
//        } else {
//            System.out.println("Autores vivos em " + ano + ":");
//            autores.forEach(autor -> {
//                System.out.println("Nome: " + autor.name() +
//                        ", Nacionalidade: " + autor.nationality() +
//                        ", Data de Nascimento: " + autor.birthYear() +
//                        ", Data de Falecimento: " + autor.deathYear());
//            });
//        }
//    }
//
//    private void listarLivrosPorIdioma() {
//        System.out.print("Digite o idioma (pt, fr, en, es): ");
//        String idioma = leitura.nextLine();
//        List<LivroDTO> livros = livroService.listarLivrosPorIdioma(idioma);
//        if (livros.isEmpty()) {
//            System.out.println("Nenhum livro encontrado para o idioma: " + idioma);
//        } else {
//            System.out.println("Livros encontrados:");
//            livros.forEach(livro -> {
//                System.out.println("Título: " + livro.title() +
//                        ", Autor: " + livro.author() +
//                        ", Idioma: " + livro.language());
//            });
//        }
//    }
}
