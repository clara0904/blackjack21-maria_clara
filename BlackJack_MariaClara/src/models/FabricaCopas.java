package models;

public class FabricaCopas implements FabricaCartas{
    @Override
    public Carta criarCarta(String nomeCarta, int valor){
        return new Copas(nomeCarta,valor);
    }
}

