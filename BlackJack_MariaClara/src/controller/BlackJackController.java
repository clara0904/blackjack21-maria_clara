package controller;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.ExcecaoPorBaralhoExcedido;
import exceptions.ExcecaoPorFaltaDeCartasBaralho;
import models.Baralho;
import models.Carta;
import models.Jogador;
import models.Partida;
import view.BlackjackView;

public class BlackJackController {
    Baralho baralho = new Baralho();;
    BlackjackView blackjackView = new BlackjackView();
    Scanner scanner = new Scanner(System.in);
    ArrayList <Jogador> jogadores = new ArrayList<>();
    Partida informacoesPartida = new Partida();
    
    public BlackJackController() throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho {
        baralho.criaBaralho();
    }

    public void recebeJogadores(){
        blackjackView.inicioJogo();
        Jogador jogador = new Jogador(blackjackView.recebeNomeJogador());
        jogadores.add(jogador);
        boolean aux = true;
        while(aux){
            Jogador novoJogador = new Jogador(blackjackView.recebeNomeJogador());
            jogadores.add(novoJogador);

            String x = blackjackView.recebeOpcaoAdicaoJogador();
            if(x.equalsIgnoreCase("S")){
                aux = true;
            }else if (x.equalsIgnoreCase("N")){
                aux = false;
            }else{
                blackjackView.opcaoInvalida();
                break;
            }
        }
    }

    int contaPartidas = 0,i=0;
    boolean partidaEmAndamento = true;
    public void inicioJogo() throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho{
        while(partidaEmAndamento){
            baralho.reiniciaCartasJogadas();
            String cartasDoJogador = blackjackView.retornaCartas(jogadores.get(i).nomeJogador);
            blackjackView.imprimeMensagem(cartasDoJogador);    
            Carta carta = baralho.retornaCarta();   baralho.addCartasJogadas(carta);    baralho.removeCartaBaralho(carta);
            carta = baralho.retornaCarta();  baralho.addCartasJogadas(carta);   baralho.removeCartaBaralho(carta);

            blackjackView.quebraDeLinha();
            baralho.imprimeCartasJogadas();

            int somaCartas = baralho.somaCartas();
            blackjackView.retornaSoma(somaCartas);
            jogadores.get(i).pontuacao = baralho.somaCartas(); 
            
            blackjackView.quebraDeLinha();
            int opcao = blackjackView.recebeOpcaoJogo();
            boolean hit = false;
            if(opcao == 1){
                hit = true;
            }else if(opcao == 2){
                hit = false;
            }else{
                blackjackView.opcaoInvalida();
            }
            while(hit){
                carta = baralho.retornaCarta();     baralho.addCartasJogadas(carta);    baralho.removeCartaBaralho(carta);
                blackjackView.quebraDeLinha();
                baralho.imprimeCartasJogadas();
                somaCartas = baralho.somaCartas();
                blackjackView.retornaSoma(somaCartas);
                jogadores.get(i).pontuacao = baralho.somaCartas();

                if(baralho.testVitoriaUmVencedor()){
                    jogadores.get(i).vencedor = true;
                    blackjackView.vencedorPorBlackjack(jogadores.get(i).nomeJogador);
                    hit = false;
                }else if(baralho.testEstouro()){
                    jogadores.get(i).vencedor = false;
                    blackjackView.estouro();
                    hit = false;
                }else{
                    blackjackView.quebraDeLinha();
                    opcao = blackjackView.recebeOpcaoJogo();
                    if(opcao==1){
                        hit=true;
                    } else if (opcao == 2) {
                        break;
                    }else{
                        blackjackView.opcaoInvalida();
                    }
                }
            }
            i++;
            String resultadoPartida = null;
            if(i>=jogadores.size()){ 
                boolean teveBlackJack = false;
                for (Jogador procuraVencedor : jogadores) {
                    if(procuraVencedor.vencedor == true){   //busca por jogador único que fez blackjack
                        if(baralho.testVitoriaMaisDeUmVencedor(jogadores)){ //busca por mais de um jogador que fez blackjack
                            for (Jogador procuraVencedores : jogadores) {
                                resultadoPartida = "Jogador vencedor: "+procuraVencedores.nomeJogador;
                            }
                        break;
                        }
                        resultadoPartida = "Jogador vencedor: "+procuraVencedor.nomeJogador;
                        teveBlackJack = true;
                    }
                }
                if(teveBlackJack){
                    blackjackView.imprimeMensagem(resultadoPartida+"\n");
                }else{  //se nenhum fez blackjack, busca por empate ou vitoria por proximidade
                    if(baralho.testEmpateMaiorQue21(jogadores) || baralho.testEmpateIgualBlackJack(jogadores) || baralho.testEmpateMenorQue21(jogadores)){ //empate
                        resultadoPartida = "Partida empatadada!";
                        blackjackView.imprimeMensagem(resultadoPartida+"\n");    
                    }else if(baralho.testSemVitoriaSemEmpate(jogadores)){   //vitoria por proximidade de 21
                        for (Jogador jogadorVitoria : jogadores) {
                            if(jogadorVitoria.vencedor == true){
                                resultadoPartida = "Jogador vencedor: "+jogadorVitoria.nomeJogador;
                                blackjackView.imprimeMensagem(resultadoPartida+"\n");
                                break;
                            }
                        }
                    }
                }


                informacoesPartida.addPartida(contaPartidas, jogadores);    //adiciono as informações da partida
                opcao = blackjackView.recebeOpcaoNovaPartida();
                if(opcao == 1) {
                    contaPartidas++;
                    baralho.reiniciaBaralho();  //baralho inteiro novamente
                    informacoesPartida.zeraResultadoJogadorPorPartida(jogadores);   //vencedor = false
                    i=0;
                    partidaEmAndamento=true;
                } else if (opcao == 2) {
                    informacoesPartida.imprimeInformacoesPartidas();    //imprime todas as informações de todas as partidas
                    partidaEmAndamento = false; 
                }else{
                    blackjackView.opcaoInvalida();
                    break;
                }
            }
        }
    }
}


