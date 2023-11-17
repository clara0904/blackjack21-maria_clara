package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import models.Baralho;
import models.Jogador;

/**
 * Quando empata?
 *    se todos os jogadores tem 21
 *    se todos os jogadores tiverem estouro 
 */

public class RegrasDeEmpateTest {
    private Baralho baralho;

    @BeforeEach
	public void setup() {
		baralho = new Baralho();
	}

    @ParameterizedTest
	@CsvSource({"Joaozinho,21,Pedrinho,21,true", "Carlinhos,21,Marquinhos,20,false","Dona Silvana,20,Seu Miguel,12,false"}) //PRECISO DE NO MINIMO 2 JOGADORES NA PARTIDA(TODOS DEVEM SOMAR 21)
	public void testVerificaEmpateBlackJackEntreDoisJogadores(String nomeJogador1, int pontuacao1, String nomeJogador2, int pontuacao2, boolean resultadoEsperado){
		Jogador jogador = new Jogador(nomeJogador1);
		jogador.pontuacao = pontuacao1;
		Jogador jogador2 = new Jogador(nomeJogador2);
		jogador2.pontuacao = pontuacao2;

		ArrayList<Jogador> jogadores = new ArrayList<>();
		jogadores.add(jogador);	jogadores.add(jogador2);
		assertEquals(resultadoEsperado, baralho.testEmpateIgualBlackJack(jogadores));
	}


	@ParameterizedTest
	@CsvSource({"Joaozinho,21,Pedrinho,21,false", "Carlinhos,21,Marquinhos,20,false","Dona Silvana,22,Seu Miguel,30,true"}) //PRECISO DE NO MINIMO 2 JOGADORES NA PARTIDA(TODOS DEVEM SOMAR MAIS QUE 21)
	public void testVerificaEmpateMaiorQue21EntreDoisJogadores(String nomeJogador1, int pontuacao1, String nomeJogador2, int pontuacao2, boolean resultadoEsperado){
		Jogador jogador = new Jogador(nomeJogador1);
		jogador.pontuacao = pontuacao1;
		Jogador jogador2 = new Jogador(nomeJogador2);
		jogador2.pontuacao = pontuacao2;

		ArrayList<Jogador> jogadores = new ArrayList<>();
		jogadores.add(jogador);	jogadores.add(jogador2);
		assertEquals(resultadoEsperado, baralho.testEmpateMaiorQue21(jogadores));
	}

	@ParameterizedTest
	@CsvSource({"Joaozinho,20,Pedrinho,20,true", "Carlinhos,21,Marquinhos,20,false","Dona Silvana,22,Seu Miguel,30,false","Andre,15,Joao,19,false"}) //PRECISO DE NO MINIMO 2 JOGADORES NA PARTIDA(TODOS DEVEM TER PONTUACAO IGUAL E MENOR QUE 21)
	public void testVerificaEmpateMenorQue21EntreDoisJogadores(String nomeJogador1, int pontuacao1, String nomeJogador2, int pontuacao2, boolean resultadoEsperado){
		Jogador jogador = new Jogador(nomeJogador1);
		jogador.pontuacao = pontuacao1;
		Jogador jogador2 = new Jogador(nomeJogador2);
		jogador2.pontuacao = pontuacao2;

		ArrayList<Jogador> jogadores = new ArrayList<>();
		jogadores.add(jogador);	jogadores.add(jogador2);
		assertEquals(resultadoEsperado, baralho.testEmpateMenorQue21(jogadores));
	}
}
