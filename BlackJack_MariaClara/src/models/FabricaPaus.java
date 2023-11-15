package models;

public class FabricaPaus implements FabricaCartas{
    @Override
    public Carta criarCarta(String nomeCarta, int valor){
        return new Paus(nomeCarta, valor);
    }

}
