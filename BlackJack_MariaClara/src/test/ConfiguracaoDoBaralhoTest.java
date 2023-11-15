package test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.ExcecaoPorBaralhoExcedido;
import exceptions.ExcecaoPorFaltaDeCartasBaralho;
import models.Baralho;
import models.Carta;

public class ConfiguracaoDoBaralhoTest {
    private Baralho baralho;

    @Test
	public void testInicializacaoBaralho() throws ExcecaoPorBaralhoExcedido, ExcecaoPorFaltaDeCartasBaralho{
		baralho = new Baralho();
        baralho.criaBaralho();
        ArrayList <Carta> recebeBaralho = baralho.getBaralho();
        int tamanhoBaralhoConvencional = 52;
        assertEquals(tamanhoBaralhoConvencional,recebeBaralho.size());  //verifica se o baralho criado tem exatamente 52 cartas 
    } 
}
