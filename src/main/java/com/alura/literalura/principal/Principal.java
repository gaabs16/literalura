package com.alura.literalura.principal;

import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.dto.Resposta;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DadosAutor;
import com.alura.literalura.model.DadosLivro;
import com.alura.literalura.model.Livro;
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
                    4- listar autores vivos em um determinado ano(query)
                    5- listar livros em um determinado idioma(query)
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEmAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
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
        DadosAutor dadosAutor = conversor.obterDadosAutor(response, DadosAutor.class);
        DadosLivro dadosLivro = conversor.obterDadosLivro(response, DadosLivro.class);
        if (dadosLivro != null && dadosAutor != null) {

            Livro livro = new Livro(dadosLivro);

            salvarLivro(livro);

        } else {
            System.out.println("Não foi possível obter dados válidos do JSON.");
        }
    }

    private void salvarLivro(Livro salva) {
         livroService.salvarLivro(salva);
    }

    private void listarLivrosRegistrados() {
        List<LivroDTO> livros = livroService.listarLivrosRegistrados();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            System.out.println("Livros registrados:");
            livros.forEach(livro -> {
                System.out.println("Título: " + livro.title() +
                        "Autor: " + livro.author() +
                        "Idioma: " + livro.language() +
                        "Download " + livro.downloads() );
            });
        }
    }


    private void listarAutoresRegistrados() {
        List<AutorDTO> autores = livroService.listarAutoresRegistrados();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            System.out.println("Autores registrados:");
            autores.forEach(autor -> {
                System.out.println("Nome: " + autor.name() +
                        ", Data de Nascimento: " + autor.birthYear() +
                        ", Data de Falecimento: " + autor.deathYear());
            });
        }
    }

    private void listarAutoresVivosEmAno() {
        System.out.print("Digite o ano: ");
        int ano = leitura.nextInt();
        List<AutorDTO> autores = livroService.listarAutoresVivosEmAno(ano);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado vivo no ano: " + ano);
        } else {
            System.out.println("Autores vivos em " + ano + ":");
            autores.forEach(autor -> {
                System.out.println("Nome: " + autor.name() +
                        ", Data de Nascimento: " + autor.birthYear() +
                        ", Data de Falecimento: " + autor.deathYear());
            });
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.print("Digite o idioma (pt, fr, en, es): ");
        String idioma = leitura.nextLine();
        List<LivroDTO> livros = livroService.listarLivrosPorIdioma(idioma);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o idioma: " + idioma);
        } else {
            System.out.println("Livros encontrados:");
            livros.forEach(livro -> {
                System.out.println("Título: " + livro.title() +
                        ", Autor: " + livro.author() +
                        ", Idioma: " + livro.language());
            });
        }
    }
}
