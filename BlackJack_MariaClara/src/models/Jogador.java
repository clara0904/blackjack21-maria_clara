package models;

public class Jogador {
    public String nomeJogador;
    public int pontuacao;
    public boolean vencedor;

    public Jogador(String nomeJogador){
        this.nomeJogador = nomeJogador;
        this.pontuacao = 0;
    }

    public Jogador(String nomeJogador, int pontuacao, boolean vencedor) {
        this.nomeJogador = nomeJogador;
        this.pontuacao = pontuacao;
        this.vencedor = vencedor;
    }

    @Override
    public String toString() {
    return " = " + nomeJogador + "\n";
}
}
