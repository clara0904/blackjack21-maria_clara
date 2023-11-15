package exceptions;

public class ExcecaoPorFaltaDeCartasBaralho extends Exception{
    public ExcecaoPorFaltaDeCartasBaralho(){
        super("ERRO! Faltam cartas no baralho.");
    }  
}
