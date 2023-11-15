package models;

public class Carta {
    protected String nomeCarta;
    protected int valor;
    protected char simbolo;

    public Carta(String nomeCarta, int valor){
        this.nomeCarta = nomeCarta;
        this.valor = valor;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: "+nomeCarta);
        return sb.toString();
    }

    public String getNome(){return nomeCarta;}
    public int getValor(){return valor;}
}

