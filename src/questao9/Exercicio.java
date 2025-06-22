package questao9;

import java.util.List;

public class Exercicio {
    private int numero;
    private String nome;
    private List<String> musculos;

    public Exercicio(int numero, String nome, List<String> musculos) {
        this.numero = numero;
        this.nome = nome;
        this.musculos = musculos;
    }

    public String toString() {
        return numero + " " + nome + " - " + String.join(", ", musculos);
    }

    public int getNumero() { return numero; }
}