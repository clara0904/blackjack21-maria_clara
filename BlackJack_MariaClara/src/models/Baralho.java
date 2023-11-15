package models;

import java.util.ArrayList;

import exceptions.ExcecaoPorBaralhoExcedido;
import exceptions.ExcecaoPorFaltaDeCartasBaralho;




public class Baralho {
    ArrayList <Carta> baralho = new ArrayList<>();
    ArrayList <Carta> cartasJogadas = new ArrayList<>();
    public void criaBaralho()throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho{
        //NAIPE COPAS
        FabricaCartas fabricaCopas = new FabricaCopas();
        baralho.add(fabricaCopas.criarCarta("Dama(Q) de Copas",10));
        baralho.add(fabricaCopas.criarCarta("Valete(J) de Copas",10));
        baralho.add(fabricaCopas.criarCarta("Rei(K) de Copas",10));
        baralho.add(fabricaCopas.criarCarta("A de Copas",1));
        baralho.add(fabricaCopas.criarCarta("2 de Copas",2));
        baralho.add(fabricaCopas.criarCarta("3 de Copas",3));
        baralho.add(fabricaCopas.criarCarta("4 de Copas",4));
        baralho.add(fabricaCopas.criarCarta("5 de Copas",5));
        baralho.add(fabricaCopas.criarCarta("6 de Copas",6));
        baralho.add(fabricaCopas.criarCarta("7 de Copas",7));
        baralho.add(fabricaCopas.criarCarta("8 de Copas",8));
        baralho.add(fabricaCopas.criarCarta("9 de Copas",9));
        baralho.add(fabricaCopas.criarCarta("10 de Copas",10));

        //NAIPE ESPADAS
        FabricaCartas fabricaEspadas = new FabricaEspadas();
        baralho.add(fabricaEspadas.criarCarta("Dama(Q) de Espadas",10));
        baralho.add(fabricaEspadas.criarCarta("Valete(J) de Espadas",10));
        baralho.add(fabricaEspadas.criarCarta("Rei(K) de Espadas",10));
        baralho.add(fabricaEspadas.criarCarta("A de Espadas",1));
        baralho.add(fabricaEspadas.criarCarta("2 de Espadas",2));
        baralho.add(fabricaEspadas.criarCarta("3 de Espadas",3));
        baralho.add(fabricaEspadas.criarCarta("4 de Espadas",4));
        baralho.add(fabricaEspadas.criarCarta("5 de Espadas",5));
        baralho.add(fabricaEspadas.criarCarta("6 de Espadas",6));
        baralho.add(fabricaEspadas.criarCarta("7 de Espadas",7));
        baralho.add(fabricaEspadas.criarCarta("8 de Espadas",8));
        baralho.add(fabricaEspadas.criarCarta("9 de Espadas",9));
        baralho.add(fabricaEspadas.criarCarta("10 de Espadas",10));

        //NAIPE OURO
        FabricaCartas fabricaOuro = new FabricaOuro();
        baralho.add(fabricaOuro.criarCarta("Dama(Q) de Ouro",10));
        baralho.add(fabricaOuro.criarCarta("Valete(J) de Ouro",10));
        baralho.add(fabricaOuro.criarCarta("Rei(K) de Ouro",10));
        baralho.add(fabricaOuro.criarCarta("A de Ouro",1));
        baralho.add(fabricaOuro.criarCarta("2 de Ouro",2));
        baralho.add(fabricaOuro.criarCarta("3 de Ouro",3));
        baralho.add(fabricaOuro.criarCarta("4 de Ouro",4));
        baralho.add(fabricaOuro.criarCarta("5 de Ouro",5));
        baralho.add(fabricaOuro.criarCarta("6 de Ouro",6));
        baralho.add(fabricaOuro.criarCarta("7 de Ouro",7));
        baralho.add(fabricaOuro.criarCarta("8 de Ouro",8));
        baralho.add(fabricaOuro.criarCarta("9 de Ouro",9));
        baralho.add(fabricaOuro.criarCarta("10 de Ouro",10));

        //NAIPE OURO
        FabricaCartas fabricaPaus = new FabricaPaus();
        baralho.add(fabricaPaus.criarCarta("Dama(Q) de Paus",10));
        baralho.add(fabricaPaus.criarCarta("Valete(J) de Paus",10));
        baralho.add(fabricaPaus.criarCarta("Rei(K) de Paus",10));
        baralho.add(fabricaPaus.criarCarta("A de Paus",1));
        baralho.add(fabricaPaus.criarCarta("2 de Paus",2));
        baralho.add(fabricaPaus.criarCarta("3 de Paus",3));
        baralho.add(fabricaPaus.criarCarta("4 de Paus",4));
        baralho.add(fabricaPaus.criarCarta("5 de Paus",5));
        baralho.add(fabricaPaus.criarCarta("6 de Paus",6));
        baralho.add(fabricaPaus.criarCarta("7 de Paus",7));
        baralho.add(fabricaPaus.criarCarta("8 de Paus",8));
        baralho.add(fabricaPaus.criarCarta("9 de Paus",9));
        baralho.add(fabricaPaus.criarCarta("10 de Paus",10));
        
        if(baralho.size()>52){
            throw new ExcecaoPorBaralhoExcedido();
        }else if(baralho.size()<52){
            throw new ExcecaoPorFaltaDeCartasBaralho();
        }
    }
    

    public void imprimeBaralho(){
        for(int i=0;i<baralho.size();i++){
            System.out.println(baralho.get(i));
        }
    }

    public Carta retornaCarta(){
        Embaralha.getEmbaralhador().embaralhar(baralho);
        return baralho.get(0);
    }

    public ArrayList<Carta> getBaralho(){
		return baralho;
	}

    public ArrayList<Carta> reiniciaBaralho()throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho{
        baralho = new ArrayList<>();
        criaBaralho();
        return baralho;
    }

    public void addCartasJogadas(Carta carta){
        cartasJogadas.add(carta);
    }

    public void imprimeCartasJogadas(){
        for(int i=0;i<cartasJogadas.size();i++){
            System.out.println(cartasJogadas.get(i));
        }
    }

    public ArrayList<Carta> reiniciaCartasJogadas(){
        cartasJogadas = new ArrayList<>();
        return cartasJogadas;
    }

    public int somaCartas(){
        int soma=0;
        for (Carta carta : cartasJogadas) {
            soma+=carta.getValor();
        }
        return soma;
    }

    public void removeCartaBaralho(Carta carta){
        baralho.remove(carta);
    }

    public boolean testVitoriaUmVencedor(){
        if(somaCartas() == 21){
            return true;
        }
        return false;
    }

    public boolean testEstouro(){
        if(somaCartas() > 21){
            return true;
        }
        return false;
    }

    public boolean testVitoriaMaisDeUmVencedor(ArrayList<Jogador> jogadores){
        int cont=0;
        for(int i=0;i<jogadores.size();i++){
            if(jogadores.get(i).pontuacao == 21){
                cont++;
            }
        }
        if(cont>1){
            return true;
        }
        return false;
    }

    public boolean testEmpateIgualBlackJack(ArrayList<Jogador> jogadores){     //todos devem ser iguais a 21
        int cont=0;
        for(int i=0;i<jogadores.size();i++){
            if(jogadores.get(i).pontuacao == 21){
                cont++;
            }
        }
        if(cont==jogadores.size()){
            return true;
        }
        return false;
    }

    public boolean testEmpateMaiorQue21(ArrayList<Jogador> jogadores){  //todos devem ser maiores que 21
        int cont=0;
        for(int i=0;i<jogadores.size();i++){
            if(jogadores.get(i).pontuacao > 21){
                cont++;
            }
        }
        if(cont==jogadores.size()){
            return true;
        }
        return false;
    }

    public boolean testSemVitoriaSemEmpate(ArrayList<Jogador> jogadores){  //qual jogador chegou mais perto de 21
        if (testVitoriaUmVencedor() || testVitoriaMaisDeUmVencedor(jogadores) || testEmpateMaiorQue21(jogadores) || testEmpateIgualBlackJack(jogadores)) {
            return false;
        }
    
        int maiorPontuacao = 0;
        Jogador jogadorVencedor = null;
    
        for (Jogador jogador : jogadores) {
            if (jogador.pontuacao < 21 && jogador.pontuacao > maiorPontuacao) {
                maiorPontuacao = jogador.pontuacao;
                jogadorVencedor = jogador;
            }
        }
    
        if (jogadorVencedor != null) {
            jogadorVencedor.vencedor = true;
        }
    
        return true;
    }

    
}
