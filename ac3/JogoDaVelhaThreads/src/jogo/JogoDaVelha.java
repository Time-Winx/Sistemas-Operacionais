package jogo;

import java.util.Arrays;
import java.util.Scanner;

public class JogoDaVelha {
    private static final int qtde_jogadores = 2;
    private static final Scanner scanner = new Scanner(System.in);

    // Simbolos das jogadas
    private static final char[] lista_simbolos = {'X', 'O'};

    // Array com mensagem resultado de status
    private static final String[] codigos_status = {
            "Ocorreu um empate",
            "Jogador 0 venceu",
            "Jogador X venceu"};

    public static void main(String[] args) {

        game();

    }
    /**
     * Representação do tabuleiro como uma matriz de caracteres 3x3.
     *
     * @return Matriz de caracteres 3x3 com algum valor que indique que a posição não foi ocupada
     */
    public static char[][] initialize() {

        return new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }

    /**
     * Exexução da logica do jogo
     * LOGICA:
     * O jogador `O`sempre deve iniciar
     * A cada jogada, a matriz do jogo deverá ser exibida na tela.
     * Ao final do jogo, esse método deve mostrar o resultado
     */
    public static void game() {

        Status statusDoJogo = new Status();

        ValidadorDeJogada valida = new ValidadorDeJogada();

        char[][] main_matrix = initialize();

        ListaJogadores lista_jogadores = new ListaJogadores();

        System.out.println("""
                Bem vindo ao jogo da velha!
                para iniciar, vamos definir os nomes dos jogadores
                """);

        for (int i = 1; i <= qtde_jogadores; i++) {

            System.out.printf("\nInsira o nome do jogador %d%n\n", i);

            String nome_jogador = scanner.nextLine();

            Jogador jogador = new Jogador(nome_jogador, i, lista_simbolos[i - 1]);

            System.out.printf("""
                            Olá %s !!!
                            Você ficará com o simbolo %C
                            """,
                    nome_jogador, lista_simbolos[i - 1]);

            lista_jogadores.add(jogador);
        }

        System.out.println("\n\n----INiCIANDO O JOGO----\n\n");

        print_tabuleiro(main_matrix);

        int status = statusDoJogo.status(main_matrix);

        while (status == -1) {

            boolean valores_validos = false;

            while (!valores_validos) {

                System.out.printf("%s('%c'), escolha a coluna: ",
                        lista_jogadores.cursor.name,
                        lista_jogadores.cursor.identifier);
                int valor_input_coluna = scanner.nextInt();
                System.out.printf("%s('%c'), escolha a linha: ",
                        lista_jogadores.cursor.name,
                        lista_jogadores.cursor.identifier);
                int valor_input_linha = scanner.nextInt();


                valores_validos = valida.step(main_matrix, valor_input_linha,
                        valor_input_coluna,
                        lista_jogadores.cursor.identifier);
            }

            status = statusDoJogo.status(main_matrix);
            if (status == -1) {
                System.out.println("Jogo pode continuar");
            } else {
                System.out.println(codigos_status[status]);
            }
            lista_jogadores.to_proximo();
            print_tabuleiro(main_matrix);

        }

        System.out.println(codigos_status[status]);

    }

    public static void print_tabuleiro(char[][] tabuleiro) {

        System.out.println(Arrays.deepToString(tabuleiro).replace(
                "], ", "\n").replace("[", "").replace(
                "]]", "").replace(",", ""));
        System.out.println("\n");

    }

}
