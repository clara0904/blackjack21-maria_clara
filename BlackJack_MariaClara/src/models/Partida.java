package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Partida {
    private Map<Integer, ArrayList<Jogador>> informacoesPartidas;
    Baralho baralho = new Baralho();
    

    public Partida() {
        informacoesPartidas = new HashMap<>();
    }

    public Partida(Partida novaPartida) {
        this.informacoesPartidas = new HashMap<>(novaPartida.informacoesPartidas);
    }

    public void addPartida(int numeroPartida, ArrayList<Jogador> jogadores){
        ArrayList<Jogador> copiaJogadores = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            copiaJogadores.add(new Jogador(jogador.nomeJogador, jogador.pontuacao, jogador.vencedor));  
        }
        informacoesPartidas.put(numeroPartida, copiaJogadores);
    }

    public void zeraResultadoJogadorPorPartida(ArrayList<Jogador> jogadores){
        for (Jogador jogador : jogadores) {
            jogador.vencedor = false;
        }
    }

    String resultadoPartida;
    public void imprimeInformacoesPartidas(){
        System.out.println("\n--------Resultados de todas as partidas--------");
        for (Map.Entry<Integer, ArrayList<Jogador>> elemento : informacoesPartidas.entrySet()) {
            Integer numeroPartida = elemento.getKey();
            ArrayList<Jogador> jogadores = elemento.getValue();
            System.out.println("Partida " + (numeroPartida + 1) + ":");
            boolean teveVencedor = false;
            boolean teveEmpate = false;

            for (Jogador jogador : jogadores) {
                System.out.println("Jogador: " + jogador.nomeJogador + ", Pontuação: " + jogador.pontuacao + ", Vencedor: " + jogador.vencedor);
            
                if(jogador.vencedor == true){
                    resultadoPartida = "Vitória de " + jogador.nomeJogador;
                    teveVencedor = true;
                }if(teveVencedor == false){
                    if (baralho.testEmpateMaiorQue21(jogadores) || baralho.testEmpateIgualBlackJack(jogadores)||baralho.testEmpateMenorQue21(jogadores)) {
                    resultadoPartida = "Empate!";
                    teveEmpate = true;
                } else if (baralho.testSemVitoriaSemEmpate(jogadores) && teveVencedor == false) {
                    for (Jogador jogadorVitoria : jogadores) {
                        if (jogadorVitoria.vencedor) {
                            resultadoPartida = "Vitória de " + jogadorVitoria.nomeJogador;
                            teveVencedor = true;
                            break;
                        }
                    }
                }
                }
            }

        if (teveVencedor) {
            System.out.println("O resultado da partida foi: " + resultadoPartida);
        } else if (teveEmpate) {
            System.out.println("O resultado da partida foi: Empate!");
        }
        
        System.out.println("-----------------------------------------------");
        }
    }

}


//onde ficará as informações da partida(empates, vitorias, pontuaçoes e nomes dos ganhadores)
