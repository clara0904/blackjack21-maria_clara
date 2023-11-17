import controller.BlackJackController;

public class Main {
    public static void main(String[] args) throws Exception {
        BlackJackController blackJackController = new BlackJackController();
        blackJackController.recebeJogadores();
        blackJackController.inicioJogo();
    }
}

