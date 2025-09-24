package services;

import entities.*;
import utils.IOUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static utils.IOUtils.println;
import static utils.IOUtils.validateLocalDte;

public class JogoService {

    public final String MENU_JOGOS = """
                        Digite a opção desejada:
                        1 - Cadastrar novo jogo
                        2 - Listar jogos cadastrados
                        3 - Remover jogo
                        4 - Avaliar Jogo
                        5 - Listar avaliações de um jogo
                        0 - Voltar
                        """;

    public void AdicionarJogo(Scanner scan, ArrayList<Conteudo> catalogo){
        System.out.println("Digite o nome do jogo que deseja cadastrar:");
        var titulo = scan.nextLine();
        System.out.println("Digite a plataforma do jogo:");
        var plataforma = scan.nextLine();

        var dataLancamento = LocalDate.now();

        while (true) {
            System.out.println("Digite a data de lançamento do jogo (YYYY-MM-DD):");
            var dataLancamentoInput = scan.nextLine();
            if(validateLocalDte(dataLancamentoInput)) {
                dataLancamento = LocalDate.parse(dataLancamentoInput);
                break;
            }
        }

        var jogo = new Jogo();
        jogo.titulo = titulo;
        jogo.plataforma = plataforma;
        jogo.dataLancamento = dataLancamento;

        catalogo.add(jogo);
        System.out.println("entities.Jogo " + jogo.titulo + " cadastrado com sucesso!");

    }

    public void ListarJogos(ArrayList<Conteudo> catalogo){
        System.out.println("Listando jogos cadastrados: ");
        var index = 1;
        for (var jogo : catalogo) {
            System.out.println(index + " - " + jogo);
            index++;
        }
    }

    public void RemoverJogo(Scanner scan, ArrayList<Conteudo> catalogo){
        IOUtils.println("Digite o número do jogo que deseja remover:");
        var numJogo = IOUtils.scanInt(scan);
        scan.nextLine();
        while (numJogo < 0 || numJogo > catalogo.size()) {
            println("Jogo" + numJogo + "não encontrado!, digite um jogo válido");
            numJogo = IOUtils.scanInt(scan);
        }
         
    }

    public void AvaliarJogo(Scanner scan, ArrayList<Conteudo> catalogo){
        IOUtils.println("Digite o número do jogo que deseja avaliar: ");
        var numJogo = IOUtils.scanInt(scan);
        var jogo = (Jogo) catalogo.get(numJogo);

        IOUtils.println("Digite seu nome:");
        var nome = scan.nextLine();
        IOUtils.println("Digite sua nota (0 a 10):");
        var nota = IOUtils.scanInt(scan);
        while (nota > 10 || nota < 0) {
            println("Nota inválida! Digite uma nota entre 0 e 10.");
            nota = IOUtils.scanInt(scan);
        }
        IOUtils.println("Digite seu comentário:");
        var comentario = scan.nextLine();

        var avaliacao = new Avaliacao();
        avaliacao.nomeUsuario = nome;
        avaliacao.nota = nota;
        avaliacao.comentario = comentario;
        avaliacao.dataLancamento = LocalDate.now();

        jogo.Avaliacoes.add(avaliacao);
        IOUtils.println("Avaliação adicionada com sucesso!");
    }

    public void ListarAvaliacoes(Scanner scan, ArrayList<Conteudo> catalogo){
        IOUtils.println("Digite o número do jogo que deseja ver as avaliações:");

        var numJogo = IOUtils.scanInt(scan);
        var jogo = (Jogo) catalogo.get(numJogo);

        for (var avaliacao : jogo.Avaliacoes)
            IOUtils.println(avaliacao.toString());
    }
}

