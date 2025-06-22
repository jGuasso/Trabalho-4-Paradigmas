package questao9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Plano plano;
    private List<Treino> treinos = new ArrayList<>();
    private List<RegistroTreino> registros = new ArrayList<>();

    public Aluno(String cpf, String nome, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    // Getters e Setters
    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }
    public List<Treino> getTreinos() { return treinos; }
    public List<RegistroTreino> getRegistros() { return registros; }
}
