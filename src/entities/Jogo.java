package entities;

public class Jogo extends Conteudo {
    //Atributos/Propriedades/Campos
    public String plataforma;

    @Override
    public String toString() {
        return "entities.Jogo{" +
                "titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
