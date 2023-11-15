package models;

public class FabricaOuro implements FabricaCartas{
    @Override
    public Carta criarCarta(String nomeCarta, int valor){
        return new Ouro(nomeCarta, valor);
    }
}
