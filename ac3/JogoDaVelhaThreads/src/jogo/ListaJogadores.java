package jogo;

/**
 * Classe responsavel por implementar uma lista circular encadeada
 * para fazer a transição entre os jogadores
 */
public class ListaJogadores {
    public Jogador cursor;
    protected int size;

    public void to_proximo() {
        cursor = cursor.getNext();
    }

    public void add(Jogador jogador) {
        if (cursor == null) {
            jogador.setNext(jogador);
            cursor = jogador;
        } else {
            jogador.setNext(cursor.getNext());
            cursor.setNext(jogador);
        }
        size++;
    }    
}
