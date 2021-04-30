package jogo;

/**
 * Definição de um jogador utilizndo como base a Estrtura de nodo
 */
public class Jogador {
    public String name;
    public int id;
    public char identifier;

    protected Jogador next;

    public Jogador(String user_name, int user_id, char user_identifier) {

        this.name = user_name;
        this.id = user_id;
        this.identifier = user_identifier;

    }

    /**
     * @return retorna proximo jogador
     */
    public Jogador getNext() {
        return next;
    }

    /**
     * configura jogador
     *
     * @param player jogdaor
     */
    public void setNext(Jogador player) {
        next = player;
    }
}
