package entities;

public class Jogo extends Conteudo {
    //Atributos/Propriedades/Campos
    public String plataforma;

    public int getMediaAvaliacoes(){
        if(Avaliacoes.isEmpty()) return 0;

        int soma = 0;
        for(var avaliacao : Avaliacoes)
                soma += avaliacao.nota;
        return soma / Avaliacoes.size();

    }

    @Override
    public String toString() {
        return "Jogo{" +
                "plataforma='" + plataforma + '\'' +
                ", titulo='" + titulo + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", nota =" + getMediaAvaliacoes() +
                '}';
    }
}
