package view;
import java.util.Scanner;

public class BlackjackView {
    private Scanner scanner;

    public BlackjackView() {
        scanner = new Scanner(System.in);
    }

    public void inicioJogo(){
        System.out.println("-------------------------");
        System.out.print("Bem vindo ao BlackJack21!\n");
        System.out.println("-------------------------");
    }

    public String recebeNomeJogador(){
        System.out.print("Digite o nome do jogador: ");
        return scanner.next();
    }

    public String recebeOpcaoAdicaoJogador(){
        System.out.print("Deseja adicionar mais jogadores (S) (N): ");
        return scanner.next();
    }

    public int recebeOpcaoJogo(){
        System.out.print("Deseja 1- Receber mais uma carta 2- Parar: ");
        return scanner.nextInt();
    }

    public void opcaoInvalida(){
        System.out.println("Opcao Invalida!\n");
    }

    public String retornaCartas(String nomeJogador){
        return "\nCartas do Jogador: "+nomeJogador;
    }

    public void retornaSoma(int soma){
        System.out.println("Soma das cartas: "+soma);
    }

    public void vencedorPorBlackjack(String nomeJogador){
        System.out.println("\nBlackJack! Vencedor "+nomeJogador);
    }

    public void estouro(){
        System.out.println("\nEstouro!\n");
    }

    public void verificaVencedor(){
        System.out.println("Jogador Vencedor: ");
    }

    public void verificaEmpate(){
        System.out.println("Partida Empatada!\n");
    }

    public int recebeOpcaoNovaPartida(){
        System.out.print("\nDeseja 1- Jogar nova partida 2- Parar: ");
        return scanner.nextInt();
    }

    public void quebraDeLinha(){
        System.out.println("\n");
    }

    public void imprimeMensagem(String mensagem) {
        System.out.print(mensagem);
    }
}
