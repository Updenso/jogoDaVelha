import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tabuleiro = {
            {'*', '*', '*'},
            {'*', '*', '*'},
            {'*', '*', '*'}
        };
        char jogadorAtual = 'X';
        boolean jogoAtivo = true;
        
        while (jogoAtivo) {
            exibirTabuleiro(tabuleiro);
            System.out.println("Jogador " + jogadorAtual + ", escolha uma linha (0-2): ");
            int linha = scanner.nextInt();
            System.out.println("Escolha uma coluna (0-2): ");
            int coluna = scanner.nextInt();
            
            if (tabuleiro[linha][coluna] == '*') {
                tabuleiro[linha][coluna] = jogadorAtual;
                if (verificarVitoria(tabuleiro, jogadorAtual)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (tabuleiroCheio(tabuleiro)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("O jogo empatou!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    public static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }
        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }
        // Verificar diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }
        return false;
    }

    public static boolean tabuleiroCheio(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
