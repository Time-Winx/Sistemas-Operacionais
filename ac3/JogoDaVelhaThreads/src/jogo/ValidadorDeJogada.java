package jogo;
public class ValidadorDeJogada {
    /**
     * @param M     Matriz do jogo da velha
     * @param lin   Linha da matriz
     * @param col   Coluna da matrz
     * @param gamer Codigo do jocador (X ou 0)
     * @return Retorna True se a posição puder ser preenchida
     * Retorna False se posição nao puder ser preenchida
     * OBS: Considere como posições válidas as linhas 0, 1 e 2; e as colunas 0, 1 e 2.
     */
    public boolean step(char[][] M, int lin, int col, char gamer) {

        if (lin < M.length && col < M[0].length) {
            if (M[lin][col] == '-') {
                M[lin][col] = gamer;
                return true;
            }
            System.out.println("Posição ocupada. Tente novamente");
            return false;
        }
        System.out.println("Posição inválida. Escolha novamente");
        return false;
    }
}
