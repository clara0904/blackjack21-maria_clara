import java.util.ArrayList;
import java.util.Scanner;

import models.Baralho;
import models.Carta;
import models.Jogador;
import models.Partida; 


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Baralho baralho = new Baralho();
        baralho.criaBaralho();  
        
        Partida informacoesPartida = new Partida();
        ArrayList <Jogador> jogadores = new ArrayList<>();

        System.out.print("Bem vindo ao BlackJack21!\n");
        System.out.print("Digite o nome do jogador: ");
        String player1 = scanner.next();
        Jogador jogador = new Jogador(player1);
        jogadores.add(jogador);
        boolean aux = true;
        while(aux){
            System.out.print("Digite o nome do jogador: ");
            String player = scanner.next(); //no minimo dois jogadores
            Jogador novoJogador = new Jogador(player);
            jogadores.add(novoJogador);

            System.out.print("Deseja adicionar mais jogadores (S) (N): ");
            String x = scanner.next();
            if(x.equalsIgnoreCase("S")){
                aux = true;
            }else if (x.equalsIgnoreCase("N")){
                aux = false;
            }else{
                System.out.println("Opcao Invalida!\n");
            }
        }
        System.out.println("\n");
        int contaPartidas = 0;
        
        int i=0;        
        boolean partidaEmAndamento = true;
        while(partidaEmAndamento){  

            baralho.reiniciaCartasJogadas();
            System.out.print("Cartas do Jogador: "+jogadores.get(i).nomeJogador);

            Carta carta = baralho.retornaCarta();   baralho.addCartasJogadas(carta);    baralho.removeCartaBaralho(carta);
            carta = baralho.retornaCarta();  baralho.addCartasJogadas(carta);   baralho.removeCartaBaralho(carta);
            System.out.println("\n");
            baralho.imprimeCartasJogadas();
            System.out.println("Soma das cartas: "+baralho.somaCartas()+"\n");
            jogadores.get(i).pontuacao = baralho.somaCartas();
        
            System.out.print("Deseja 1- Receber mais uma carta 2- Parar: ");
            int opcao = scanner.nextInt();
            boolean hit=false;
            if (opcao == 1) {
                hit = true;
            }else{
                System.out.println("Opcao Invalida!\n");
            }
            while (hit) {
                carta = baralho.retornaCarta();     baralho.addCartasJogadas(carta);    baralho.removeCartaBaralho(carta);//remove para n�o ter carta repetida
                System.out.println("\n");
                baralho.imprimeCartasJogadas();
                System.out.println("Soma das cartas: "+baralho.somaCartas()+"\n");
                jogadores.get(i).pontuacao = baralho.somaCartas();

                if (baralho.testVitoriaUmVencedor()) {  
                    jogadores.get(i).vencedor = true;
                    System.out.println("BlackJack! Vencedor"+jogadores.get(i)+"\n"); 
                    hit = false;                    
                } else if (baralho.testEstouro()) {
                    jogadores.get(i).vencedor = false;
                    System.out.println("Estouro!\n"); 
                    hit = false;
                }else{
                    System.out.print("Deseja 1- Receber mais uma carta 2- Parar: ");
                    opcao = scanner.nextInt();
                    if(opcao==1){
                        hit=true;
                    } else if (opcao == 2) {
                        break;
                    }else{
                        System.out.println("Opcao Invalida!\n");
                    }
                }
            }
            i++;
            String resultadoPartida=null;
            
            if(i>=jogadores.size()){ 
                boolean teveBlackJack = false;
                for (Jogador procuraVencedor : jogadores) {
                    if(procuraVencedor.vencedor == true){   //busca por jogador �nico que fez blackjack
                        resultadoPartida = "Jogador vencedor: "+procuraVencedor.nomeJogador;
                        teveBlackJack = true;
                    }
                }
                if(teveBlackJack){
                    System.out.println(resultadoPartida+"\n");
                }else{  //se nenhum fez blackjack, busca por empate ou vitoria por proximidade
                    if(baralho.testEmpateMaiorQue21(jogadores) || baralho.testEmpateIgualBlackJack(jogadores)){ //empate
                        resultadoPartida = "Partida empatadada!";
                        System.out.println(resultadoPartida+"\n");    
                    }else if(baralho.testSemVitoriaSemEmpate(jogadores)){   //vitoria por proximidade de 21
                        for (Jogador jogadorVitoria : jogadores) {
                            if(jogadorVitoria.vencedor == true){
                                resultadoPartida = "Jogador vencedor: "+jogadorVitoria.nomeJogador;
                                System.out.println(resultadoPartida+"\n");
                                break;
                            }
                        }
                    }
                }


                informacoesPartida.addPartida(contaPartidas, jogadores);    //adiciono as informa��es da partida
                System.out.print("Deseja 1- Jogar nova partida 2- Parar: ");
                opcao = scanner.nextInt();
                if(opcao == 1) {
                    contaPartidas++;
                    baralho.reiniciaBaralho();  //baralho inteiro novamente
                    informacoesPartida.zeraResultadoJogadorPorPartida(jogadores);   //vencedor = false
                    i=0;
                    partidaEmAndamento=true;
                } else if (opcao == 2) {
                    informacoesPartida.imprimeInformacoesPartidas();    //imprime todas as informa��es de todas as partidas
                    partidaEmAndamento = false; 
                }else{
                    System.out.println("Opcao Invalida!\n");
                }
            }
        }
       
    }
}

