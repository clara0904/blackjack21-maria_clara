package models;

public class FabricaEspadas implements FabricaCartas{
    @Override
    public Carta criarCarta(String nomeCarta, int valor){
        return new Espadas(nomeCarta, valor);
    }
}
    
