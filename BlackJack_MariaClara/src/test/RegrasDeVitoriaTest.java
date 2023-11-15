package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exceptions.ExcecaoPorBaralhoExcedido;
import exceptions.ExcecaoPorFaltaDeCartasBaralho;
import models.Baralho;
import models.Carta;
import models.Jogador;


/**
 * Quando sei que ganhei?
 *    soma = 21
 *    valor mais proximo de 21(sem estouro) do que o dos concorrentes
 * Quando sei que perdi?
 *    soma ultrapassa 21(estouro)
 */

public class RegrasDeVitoriaTest {
    private Baralho g;

    @BeforeEach
	public void setup() {
		g = new Baralho();
	}

    @ParameterizedTest		
	@CsvSource({"QP,10,KO,10,AE,1,21","5P,5,2C,2,3O,3,10","8C,8,5O,5,2P,2,15"})
	public void testPontuacaoComTresCartas(String nome1, int valor1, String nome2, int valor2, String nome3, int valor3, int pontuacaoEsperada) throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho {
		Carta carta = new Carta(nome1,valor1);
		Carta carta2 = new Carta(nome2,valor2);
		Carta carta3 = new Carta(nome3,valor3);
		
		g.addCartasJogadas(carta);
		g.addCartasJogadas(carta2);
		g.addCartasJogadas(carta3);
        int pontuacaoReal = g.somaCartas();
        assertEquals(pontuacaoEsperada, pontuacaoReal);
	}


	@ParameterizedTest
	@CsvSource({"10C,10,KE,10,AC,1,true","KP,10,JO,10,2P,2,false","8P,8,4C,4,9O,9,true","5E,5,9P,9,6O,6,false"})	//PRECISO DE NO MINIMO 3 CARTAS PARA VENCER
	public void testVitoriaComTresCartas(String nome1, int valor1, String nome2, int valor2, String nome3, int valor3, boolean resultadoEsperado) throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho {
		Carta carta = new Carta(nome1,valor1);
		Carta carta2 = new Carta(nome2,valor2);
		Carta carta3 = new Carta(nome3,valor3);

		g.addCartasJogadas(carta);
		g.addCartasJogadas(carta2);
		g.addCartasJogadas(carta3);
		assertEquals(resultadoEsperado,g.testVitoriaUmVencedor());
	}


	@ParameterizedTest
	@CsvSource({"10P,10,JE,10,3C,3,true","10O,10,QP,10,AC,1,false","8O,8,JC,10,10E,10,true","8P,8,10C,10,3E,3,false"}) //PRECISO DE NO MINIMO 3 CARTAS PARA ESTOURAR
	public void testEstouroComTresCartas(String nome1, int valor1, String nome2, int valor2,String nome3, int valor3, boolean resultadoEsperado) throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho {
		Carta carta = new Carta(nome1,valor1);
		Carta carta2 = new Carta(nome2,valor2);
		Carta carta3 = new Carta(nome3,valor3);

		g.addCartasJogadas(carta);
		g.addCartasJogadas(carta2);
		g.addCartasJogadas(carta3);
		assertEquals(resultadoEsperado,g.testEstouro());
	}


	@ParameterizedTest
	@CsvSource({"Joaozinho,21,Pedrinho,21,Leandrinho,20,true", "Carlinhos,21,Marquinhos,20,Januário,10,false", "Miguel,20,Andre,21,Diego,21,true"}) //PRECISO DE NO MINIMO 2 JOGADORES NA PARTIDA(MAIS DE UM VENCE)
	public void testVerificaVitoriaDeMaisDeUmVencedor(String nomeJogador1, int pontuacao1, String nomeJogador2, int pontuacao2, String nomeJogador3, int pontuacao3, boolean resultadoEsperado){
		Jogador jogador = new Jogador(nomeJogador1);
		jogador.pontuacao = pontuacao1;
		Jogador jogador2 = new Jogador(nomeJogador2);
		jogador2.pontuacao = pontuacao2;
		Jogador jogador3 = new Jogador(nomeJogador3);
		jogador3.pontuacao = pontuacao3;

		ArrayList<Jogador> jogadores = new ArrayList<>();
		jogadores.add(jogador);	jogadores.add(jogador2); jogadores.add(jogador3);
		assertEquals(resultadoEsperado, g.testVitoriaMaisDeUmVencedor(jogadores));
	}


	@ParameterizedTest
	@CsvSource({"Joaozinho,21,Pedrinho,21,false", "Carlinhos,20,Marquinhos,19,true","Dona Silvana,22,Seu Miguel,30,false","Luaninha,18,Mariano,15,true"}) //VITORIA DO JOGADOR QUE CHEGA MAIS PERTO DE 21
	public void testVerificaPartidaSemEmpateSemVitoriaConvencionais(String nomeJogador1, int pontuacao1, String nomeJogador2, int pontuacao2, boolean resultadoEsperado){
		Jogador jogador = new Jogador(nomeJogador1);
		jogador.pontuacao = pontuacao1;
		Jogador jogador2 = new Jogador(nomeJogador2);
		jogador2.pontuacao = pontuacao2;

		ArrayList<Jogador> jogadores = new ArrayList<>();
		jogadores.add(jogador);	jogadores.add(jogador2);
		assertEquals(resultadoEsperado, g.testSemVitoriaSemEmpate(jogadores));
	}

}

