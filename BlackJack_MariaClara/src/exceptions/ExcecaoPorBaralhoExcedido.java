package exceptions;

public class ExcecaoPorBaralhoExcedido extends Exception{
    public ExcecaoPorBaralhoExcedido(){
        super("ERRO! Baralho excede quantidade de cartas.");
    }  
}
