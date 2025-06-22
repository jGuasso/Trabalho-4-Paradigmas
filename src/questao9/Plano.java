package questao9;

public class Plano {
    private int codigo;
    private String nome;
    private double valorMensal;

    public Plano(int codigo, String nome, double valorMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorMensal = valorMensal;
    }

    public String toString() {
        return codigo + " " + nome + " R$" + valorMensal;
    }

    // Getters
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getValorMensal() { return valorMensal; }
}