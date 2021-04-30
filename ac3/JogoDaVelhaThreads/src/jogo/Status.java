package jogo;

public class Status {
    /**
     * @param M Matriz do jogo da valha
     * @return (- 1 - jogo pode continuar, 0 - ocorreu um empate, 1 - jogador O venceu, 2 - jogador X venceu
     *)
     */
    public int status(char M[][]) {

        // conferencia linhas
        for (char[] linha_atual : M) {

            char caracter_predominante = checkIfAllisEqual(linha_atual);

            if (caracter_predominante == 'O') {
                return 1;
            } else if (caracter_predominante == 'X') {
                return 2;
            }
        }

        // Conferencia colunas

        char valor_culunas = getCharColumn(M);

        if (valor_culunas == 'X') {
            return 2;
        } else if (valor_culunas == 'O') {
            return 1;
        }

        // Conferencia diagonal
	    // TODO: fazer conferencia diagonal

        char[] matriz_identidade = new char[M[0].length];
        for (int i = 0; i < M.length; i++) {
            matriz_identidade[i] = M[i][i];
        }

        char valor_predominante_matriz_identidade = checkIfAllisEqual(matriz_identidade);

        if (valor_predominante_matriz_identidade == 'O') {
            return 1;
        } else if (valor_predominante_matriz_identidade == 'X') {
            return 2;
        }

        char[] matriz_inversa = new char[M.length];
        for (int j = M.length - 1, i = 0; j >= 0 && i < M.length; j--, i++) {
            matriz_inversa[i] = M[i][j];
        }


        char valor_predominante_matriz_inversa = checkIfAllisEqual(matriz_inversa);

        if (valor_predominante_matriz_inversa == 'O') {
            return 1;
        } else if (valor_predominante_matriz_inversa == 'X') {
            return 2;
        }

        // fazer conferencia empate

        boolean contem_barra = false;
        for (char[] linha_atual : M) {
            for (char el : linha_atual) {
                if (el == '-') {
                    contem_barra = true;
                    break;
                }
            }
        }

        if (!contem_barra) return 0;

        return -1;
    }

    // verifica se todos os valores (sequência de 3 valores) são iguais.
    public char checkIfAllisEqual(char array[]) {

        boolean todos_os_valores_iguais = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1] || array[i - 1] == '-') {
                todos_os_valores_iguais = false;
                break;
            }
        }

        if (todos_os_valores_iguais) {
            return array[0];
        } else {
            return '-';
        }
    }

    public char getCharColumn(char nums[][]) {

        char[] vetorLinha = new char[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                vetorLinha[j] = nums[j][i];
            }

            char caracter_predominante = checkIfAllisEqual(vetorLinha);

            if (caracter_predominante != '-') return caracter_predominante;
        }

        return '-';
    }
}
