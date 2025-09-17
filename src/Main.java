import entities.Conteudo;
import services.FilmeService;
import services.JogoService;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.IOUtils.println;
import static utils.IOUtils.scanInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        var catalogo = new ArrayList<Conteudo>();
        var scan = new Scanner(System.in);
        var jogoService = new JogoService();
        var filmeService = new FilmeService();

        while (true) {
            println(MENU_PRINCIPAL);
            var conteudoOpcao = scanInt(scan);
            switch (conteudoOpcao) {
                case 0 -> System.exit(0);
                case 1 -> {
                    var voltar = false;
                    while (!voltar) {
                        println("-----------------------------------");
                        println(jogoService.MENU_JOGOS);

                        var opcao = scanInt(scan);

                        switch (opcao) {
                            case 1 -> jogoService.AdicionarJogo(scan, catalogo);
                            case 2 -> jogoService.ListarJogos(catalogo);
                            case 3 -> jogoService.RemoverJogo(scan, catalogo);
                            case 4 -> jogoService.AvaliarJogo(scan, catalogo);
                            case 0 -> voltar = true;
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 2 -> {
                    var voltar = false;
                    while (!voltar) {
                        println("-----------------------------------");
                        println(filmeService.MENU_FILME);

                        var opcao = scanInt(scan);

                        switch (opcao) {
                            case 4 -> voltar = true;
                            case 1 -> println("Cadastre novo filme - Em construção");
                            default -> println("Opção inválida!");
                        }

                    }
                }
            }
        }
    }

    public static final String MENU_PRINCIPAL = """
                        Bem vindo ao sistema de gerenciamento de mídias!
                        Digite o conteúdo que deseja gerenciar:
                        0 - Sair
                        1 - Jogos
                        2 - Filmes
                        3 - Series
                    """;
}
