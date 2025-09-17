package services;

import entities.*;
import utils.IOUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class JogoService {

    public final String MENU_JOGOS = """
                        Digite a opção desejada:
                        1 - Cadastrar novo jogo
                        2 - Listar jogos cadastrados
                        3 - Remover jogo
                        4 - Avaliar Jogo
                        5 - Listar Avaliações
                        0 - Voltar
                        """;

    public void AdicionarJogo(Scanner scan, ArrayList<Conteudo> catalogo){
        System.out.println("Digite o nome do jogo que deseja cadastrar:");
        var titulo = scan.nextLine();
        System.out.println("Digite a plataforma do jogo:");
        var plataforma = scan.nextLine();
        System.out.println("Digite a data de lançamento do jogo (YYYY-MM-DD):");
        var dataLancamento = scan.nextLine();

        var jogo = new Jogo();
        jogo.titulo = titulo;
        jogo.plataforma = plataforma;
        jogo.dataLancamento = LocalDate.parse(dataLancamento);

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
        var numJogo = scan.nextInt();
        scan.nextLine();
        catalogo.remove(numJogo - 1);
    }

    public void AvaliarJogo(Scanner scan, ArrayList<Conteudo> catalogo){
        IOUtils.println("Digite o número do jogo que deseja avaliar: ");
        var numJogo = IOUtils.scanInt(scan);
        var jogo = (Jogo) catalogo.get(numJogo);

        IOUtils.println("Digite seu nome:");
        var nome = scan.nextLine();
        IOUtils.println("Digite sua nota (0 a 10):");
        var nota = IOUtils.scanInt(scan);
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
        IOUtils.println("Digite o núero do jogo que deseja ver as avaliações");

        var numJogo = IOUtils.scanInt(scan);
        var jogo = (Jogo) catalogo.get(numJogo);

        for(var avaliacao : jogo.Avaliacoes)
            IOUtils.println(avaliacao.toString());
    }
}

